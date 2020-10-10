package com.otsazo.colorfit.command;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.DressDTO;
import com.otsazo.colorfit.beans.dao.DressDAO;

public class SaveLinkResultCommand implements Command {

	@Override
	public void execute(Model model) {
		int cnt = 0;
		Map<String, Object> map = model.asMap();
		DressDTO dto = (DressDTO)map.get("dto");
		DressDAO dao = C.sqlSession.getMapper(DressDAO.class);
		
		MultipartFile dressImg = (MultipartFile) map.get("dressImg");

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
					model.addAttribute("result", cnt);
				} catch (Exception e) {
					e.printStackTrace();
					cnt = 500; // 500 : 파일 저장 실패
					model.addAttribute("result", cnt);
					return;
				}
			} else {
				System.out.println("not an image file");
				cnt = 101; // 101 : 이미지가 아닌 다른 파일
				model.addAttribute("result", cnt);
				return;
			}
		}

	}

}
