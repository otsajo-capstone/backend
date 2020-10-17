package com.otsazo.colorfit.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.DressDTO;
import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.beans.Results;
import com.otsazo.colorfit.beans.dao.DressDAO;
import com.otsazo.colorfit.beans.dao.MemberDAO;
import com.otsazo.colorfit.command.SaveLinkResultCommand;

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
					dto.setDress_img_org(dressImg.getOriginalFilename()); //파일 원본명
					dto.setDress_img_sav(dressImg.getOriginalFilename()); //파일 저장명
					cnt = dao.insertDress(dto);
					if(cnt == 1) {
						results.setStatus(200);
					}
				} catch (Exception e) {
					e.printStackTrace();
					cnt = 500; // 500 : 파일 저장 실패
					results.setStatus(500);
				}
			} else {
				System.out.println("not an image file");
				cnt = 101; // 101 : 이미지가 아닌 다른 파일
				results.setStatus(101);
			}
		}

		return results;
	}
	
	@RequestMapping("/myDressRoom/{mb_uid}")
	public Results mydressroom(@PathVariable("mb_uid") int mb_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		ArrayList<DressDTO> dressList = dao.selectMyDresses(mb_uid);
		if (dressList!=null) {
			results.setDlist(dressList);
			results.setStatus(200);
		}
		return results;
	}
	
	@RequestMapping("/myDressRoom/select/{dress_uid}")
	public Results selectmydress(@PathVariable("dress_uid") int dress_uid) {
		
		Results results = new Results();
		
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		DressDTO dto = dao.selectDress(dress_uid);
		if (dto!=null) {
			results.setDdto(dto);
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
	
}
