package com.otsazo.colorfit.command;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.ui.Model;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.beans.PasswordEncoding;
import com.otsazo.colorfit.beans.dao.MemberDAO;



public class MbFindPwOkCommand implements Command {

	@Override
	public void execute(Model model) {
		MemberDTO dto = null;
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		
		Map<String, Object> map = model.asMap();
		
		String mb_id = (String)map.get("mb_id");
		String mb_name = (String)map.get("mb_name");
		String mb_email = (String)map.get("mb_email");  

		final String SMTP_USERNAME = "b2nyb2st77@naver.com";
		final String SMTP_PASSWORD = "merry1125!";
		String HOST = "smtp.naver.com";

		Properties props = new Properties();   
		props.put("mail.smtp.host", HOST); 
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
			}   
		});
		
		try {
			dto = dao.selectPw(mb_id, mb_name, mb_email);
			int result = 0;
	        if(dto != null) {
	        	int cnt = 0;
	        	
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
		
				   message.setSubject("��й�ȣ �ȳ��Դϴ�.");
				   message.setText(dto.getMb_name() + " ������ �ӽ� ��й�ȣ��  " + ranPw + "�Դϴ�.\\n�ӽú�й�ȣ�� �α��� �� �� �ݵ�� ��й�ȣ ������ ���ֽñ� �ٶ��ϴ�.");

				   Transport.send(message);
		         
		           result++;
	        	}
           } else {
        	   result = 0;
           }     
           model.addAttribute("findPwOk", result);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
