package com.otsazo.colorfit.controller;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.beans.PasswordEncoding;
import com.otsazo.colorfit.beans.Results;
import com.otsazo.colorfit.beans.dao.MemberDAO;
import com.otsazo.colorfit.command.LoginCommand;
import com.otsazo.colorfit.command.MbFindIdOkCommand;
import com.otsazo.colorfit.command.MbFindPwOkCommand;
import com.otsazo.colorfit.command.MypageCommand;
import com.otsazo.colorfit.command.MypageOkCommand;
import com.otsazo.colorfit.command.SignUpOkCommand;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	/*
	 * @RequestMapping("/findIdPw") public String findIdPw(Model model) { return
	 * "/member/findIdPw"; }
	 */
	
	@RequestMapping("/findId/{mb_name}/{mb_email:.+}/")
	public Results findIdOk(@PathVariable("mb_name") String mb_name, @PathVariable("mb_email") String mb_email) {
		
		MemberDTO dto = null;
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		Results results = new Results();
		
		dto = dao.selectId(mb_name, mb_email);
		
		if(dto != null && mb_name.equals(dto.getMb_name())) {

			String findId = dto.getMb_id().substring(0, 5) + dto.getMb_id().substring(5).replace(dto.getMb_id().substring(5), "*****");
			results.setStringResult(findId);
			results.setStatus(200);
		
		} else {
			results.setStatus(400);
		}
		
		return results;

	}

	
	@RequestMapping("/findPw/{mb_id}/{mb_name}/{mb_email:.+}/")
	public Results findPwOk(@PathVariable("mb_id") String mb_id, @PathVariable("mb_name") String mb_name, @PathVariable("mb_email") String mb_email) {

		MemberDTO dto = null;
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class); 
		Results results = new Results();

		final String SMTP_USERNAME = "b2nyb2st77@naver.com";
		final String SMTP_PASSWORD = "merry1125";
		String HOST = "smtp.naver.com";

		Properties props = new Properties();   
		props.put("mail.smtp.host", HOST); 
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
			}   
		});
		
		int result = 0;
		int cnt = 0;
		
		try {
			dto = dao.selectPw(mb_id, mb_name, mb_email);
	        if(dto != null) {
	        	
	        	if(mb_id.equals(dto.getMb_id()) && mb_name.equals(dto.getMb_name()) && mb_email.equals(dto.getMb_email())) {

		            char pwCollection[] = new char[] {
	                        '1','2','3','4','5','6','7','8','9','0',
	                        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
	                        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
	                        '!','@','#','$','%','^','&','*','(',')'};
	
				      String ranPw = "";
				
				      for (int i = 0; i < 7; i++) {
				        int selectRandomPw = (int)(Math.random()*(pwCollection.length));
				        ranPw += pwCollection[selectRandomPw];
				      }
		        	PasswordEncoding pe = new PasswordEncoding();
		        	
		        	cnt = dao.updatePw(pe.encode(ranPw), dto.getMb_id());
		        	
		        	String TO = dto.getMb_email();
	
				   MimeMessage message = new MimeMessage(session);
				   message.setFrom(new InternetAddress(SMTP_USERNAME));
				   message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
		
				   message.setSubject("비밀번호 안내입니다.");
				   message.setText(dto.getMb_name() + " 고객님의 임시 비밀번호는  " + ranPw + "입니다. 임시비밀번호로 로그인 한 뒤 반드시 비밀번호 변경을 해주시기 바랍니다.");

				   Transport.send(message);
		         
		           result++;
	        	}
           } else {
        	   result = 0;
           } 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		if(result == 1) {
			results.setStatus(200);
		} else {
			results.setStatus(400);
		}
		
		return results;
		
	}
	
	/*
	 * @RequestMapping("/signUp") public String signUp(Model model) { return
	 * "/member/signUp"; }
	 */
	
	@RequestMapping("/signUp")
	public Results signUpOk(MemberDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		Results results = new Results();
		int cnt = 0;
		PasswordEncoding pe = new PasswordEncoding();
		
		Map<String, Object> map = model.asMap();
		dto = (MemberDTO)map.get("dto");
		dto.setMb_pw(pe.encode(dto.getMb_pw()));
		
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		if(dao.checkId(dto.getMb_id())==0 && dao.checkEmail(dto.getMb_email())==0) {
			cnt = dao.insertMember(dto);
		}
		
		if(cnt == 1) {
			results.setStatus(200);
		} else {
			results.setStatus(400);
		}
		
		return results;

	}
	
	/*
	 * @RequestMapping("/login") public String login(Model model) { return
	 * "/member/login"; }
	 */

	@RequestMapping("/login")
	public Results loginOk(String mb_id, String mb_pw, Model model) {
		model.addAttribute("mb_id", mb_id);
		model.addAttribute("mb_pw", mb_pw);
		PasswordEncoding pe = new PasswordEncoding();
		Results results = new Results();
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		
		if(pe.matches(mb_pw, dao.selectPwById(mb_id))) {
			int mb_uid = dao.selectUidById(mb_id);
			results.setIntResult(mb_uid);
			results.setStatus(200);
		}else {
			results.setIntResult(0);
			results.setStatus(400);
		}

		return results;
	}
	
	
	 @RequestMapping("/logout")
	 public Results logout(HttpSession session) {
		 Results results = new Results();
		 results.setIntResult(0);
		 results.setStatus(200);
		 return results;
	  }
	 
	/*
	 * @RequestMapping("/main") public String main(Model model) { return
	 * "/member/main"; }
	 */
	
	@RequestMapping("/mypage/{mb_uid}")
	public Results mypage(@PathVariable("mb_uid") int mb_uid) {
		Results results = new Results();
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		MemberDTO dto = dao.selectMemberByUid(mb_uid);
		if (dto!=null) {
			results.setMdto(dto);
			results.setStatus(200);
		} else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/mypageUpdate")
	public Results mypageOk(MemberDTO dto, Model model) {
		model.addAttribute("dto", dto);
		Results results = new Results();
		int cnt = 0;
		PasswordEncoding pe = new PasswordEncoding();
		
		Map<String, Object> map = model.asMap();
		dto = (MemberDTO)map.get("dto");
		
		dto.setMb_pw(pe.encode(dto.getMb_pw()));

		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);		
		cnt = dao.updateMemberByUid(dto);
		
		if(cnt==1) {
			results.setStatus(200);
		} else {
			results.setStatus(400);	
		}
		
		return results;
	}
	
	@RequestMapping("/withdrawal/{mb_uid}")
	public Results withdrawal(@PathVariable("mb_uid") int mb_uid) {
		Results results = new Results();
		int cnt = 0;
	
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);		
		cnt = dao.deleteMemberByUid(mb_uid);
		
		if(cnt==1) {
			results.setStatus(200);
		} else {
			results.setStatus(400);	
		}
		
		return results;
	}
}
