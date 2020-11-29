package com.otsazo.colorfit.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.DressDTO;
import com.otsazo.colorfit.beans.DressMemberDTO;
import com.otsazo.colorfit.beans.LikesDTO;
import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.beans.ReplyDTO;
import com.otsazo.colorfit.beans.RereplyDTO;
import com.otsazo.colorfit.beans.Results;
import com.otsazo.colorfit.beans.dao.DressDAO;
import com.otsazo.colorfit.beans.dao.MemberDAO;

@CrossOrigin(origins="*")
@RestController
public class DressController {
	
//	@RequestMapping("/choose")
//	public String choose(Model model) {
//		return "/analysis/choose";
//	}
//	
//	@RequestMapping("/link")
//	public String link(Model model) {
//		return "/analysis/link";
//	}
//	
//	@RequestMapping("/linkResult")
//	public String linkResult(Model model) {
//		return "/analysis/linkResult";
//	}
	
	@RequestMapping("/analysis/saveResult")
	public Results saveResult(DressDTO dto, @RequestParam("dressImg") MultipartFile dressImg, Model model) {
		
		model.addAttribute("dto", dto);
		model.addAttribute("dressImg", dressImg);
		Results results = new Results();
		
		int cnt = 0;
		Map<String, Object> map = model.asMap();
		dto = (DressDTO)map.get("dto");
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		
		dressImg = (MultipartFile) map.get("dressImg");

		ServletContext context = C.context;
		String saveDirectory = context.getRealPath("image");
		
		if(dressImg.getOriginalFilename() == "" || dressImg.getOriginalFilename() == null) {
			System.out.println("no file");
		} else {
			String contentType = dressImg.getContentType();
			if(contentType.equals("image/jpg") || contentType.equals("image/jpeg") || contentType.equals("image/png") || contentType.equals("image/gif")) {
				File saveFile = new File(saveDirectory, dressImg.getOriginalFilename());
				try {
					dressImg.transferTo(saveFile);
					dto.setDress_img_org(dressImg.getOriginalFilename()); //占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
					dto.setDress_img_sav(dressImg.getOriginalFilename()); //占쏙옙占쏙옙 占쏙옙占쏙옙占�
					cnt = dao.insertDress(dto);
					if(cnt == 1) {
						results.setStatus(200);
					}
				} catch (Exception e) {
					e.printStackTrace();
					cnt = 500; // 500 : 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
					results.setStatus(500);
				}
			} else {
				System.out.println("not an image file");
				cnt = 101; // 101 : 占싱뱄옙占쏙옙占쏙옙 占싣댐옙 占쌕몌옙 占쏙옙占쏙옙
				results.setStatus(101);
			}
		}

		return results;
	}
	
	@RequestMapping("/analysis/saveLinkResult")
	public Results saveLinkResult2(DressDTO dto) {

		Results results = new Results();
		
		int cnt = 0;

		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);

		cnt = dao.insertDress(dto);
		
		if(cnt == 1) {
			results.setStatus(200);
		} else {
			results.setStatus(400);
		}

		return results;
	}
	
	@RequestMapping("/analysis/saveImageResult")
	public Results saveImageResult3(DressDTO dto) {

		Results results = new Results();
		
		int cnt = 0;

		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);

		cnt = dao.insertDress2(dto);
		
		if(cnt == 1) {
			results.setStatus(200);
		} else {
			results.setStatus(400);
		}

		return results;
	}
	
	@RequestMapping("/myDressRoom/{mb_uid}")
	public Results mydressroom(@PathVariable("mb_uid") int mb_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		ArrayList<DressDTO> dressList = dao.selectMyDresses(mb_uid);
		ArrayList<LikesDTO> likedressList = dao.selectMyLikes(mb_uid);
		ArrayList<ReplyDTO> rlist = dao.selectMyReply(mb_uid);
		ArrayList<RereplyDTO> rrlist = dao.selectMyRereply(mb_uid);
		if (dressList!=null) {
			results.setDlist(dressList);
		}
		if (likedressList!=null) {
			results.setLlist(likedressList);
		}
		if (rlist!=null) {
			results.setRlist(rlist);
		}
		if (rlist!=null) {
			results.setRrlist(rrlist);
		}
		results.setStatus(200);
		return results;
	}
	
	@RequestMapping("/DressRoom/selectDress/{dress_uid}/{mb_uid}")
	public Results selectdress(@PathVariable("dress_uid") int dress_uid, @PathVariable("mb_uid") int mb_uid) {

		Results results = new Results();
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		DressMemberDTO dress = dao.selectDress(dress_uid);
		ArrayList<ReplyDTO> rlist = dao.selectDressReply(dress_uid);
		LikesDTO like = dao.checkLikesType(dress_uid, mb_uid);
		
		if (dress!=null) {
			results.setDdto(dress);
			if (rlist != null) {
				results.setRlist(rlist);
			}
			if (like == null) {
				results.setIntResult(0);
			}else {
				results.setIntResult(like.getLikes_type());
			}
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	
	@RequestMapping("/myDressRoom/update")
	public Results updatemydress(DressDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.updateDress(dto);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/myDressRoom/delete/{dress_uid}")
	public Results deletemydress(@PathVariable("dress_uid") int dress_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.deleteDress(dress_uid);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/select/{mb_type}")
	public Results selectyourdress(@PathVariable("mb_type") int mb_type) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		ArrayList<DressDTO> dto = dao.selectYourDresses(mb_type);
		
		if (dto!=null) {
			results.setDlist(dto);
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/insertReply")
	public Results insertReply(ReplyDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.insertReply(dto);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/updateReply")
	public Results updateReply(ReplyDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.updateReply(dto);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/deleteReply/{reply_uid}")
	public Results deleteReply(@PathVariable("reply_uid") int reply_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.deleteReply(reply_uid);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/likeDress")
	public Results likeDress(LikesDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.likeDress(dto);
		int cnt2 = dao.likeDress2(dto);
		
		if (cnt == 1 && cnt2 == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/unlikeDress")
	public Results unlikeDress(LikesDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.unlikeDress(dto);
		int cnt2 = dao.unlikeDress2(dto);
		
		if (cnt == 1 && cnt2 == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/insertRereply")
	public Results insertRereply(RereplyDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.insertRereply(dto);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/updateRereply")
	public Results updateReply(RereplyDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.updateRereply(dto);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/deleteRereply/{rereply_uid}")
	public Results deleteRereply(@PathVariable("rereply_uid") int rereply_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		int cnt = dao.deleteRereply(rereply_uid);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/yourDressRoom/selectRereply/{reply_uid}")
	public Results selectRereply(@PathVariable("reply_uid") int reply_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		ArrayList<RereplyDTO> rrlist = dao.selectRereply(reply_uid);
		
		if (rrlist != null) {
			results.setRrlist(rrlist);
			results.setStatus(200);
		}
		return results;
	}
	
	@RequestMapping("/myDressRoom/changeShareType/{dress_uid}")
	public Results changeShareType(@PathVariable("dress_uid") int dress_uid) {
		
		Results results = new Results();
		int cnt = 0;
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		cnt = dao.changeShareType(dress_uid);
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
	@RequestMapping("/DressRoom/cloneDress/{dress_uid}/{mb_uid}")
	public Results cloneDress(@PathVariable("dress_uid") int dress_uid, @PathVariable("mb_uid") int mb_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		DressMemberDTO dress = dao.selectDress(dress_uid);
		int cnt = 0;
		
		cnt = dao.insertDress3(mb_uid, dress.getSpring(), dress.getSummer(), dress.getAutumn(), dress.getWinter(), dress.getColor(), dress.getDress_link(), dress.getDress_img_org(), dress.getDress_img_sav(), dress.getDress_name(), dress.getResult());
		
		if (cnt == 1) {
			results.setStatus(200);
		}else {
			results.setStatus(400);
		}
		return results;
	}
	
}
