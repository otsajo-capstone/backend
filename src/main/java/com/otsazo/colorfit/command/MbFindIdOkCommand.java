package com.otsazo.colorfit.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.beans.dao.MemberDAO;

public class MbFindIdOkCommand implements Command {

	@Override
	public void execute(Model model) {
		MemberDTO dto = null;
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		
		Map<String, Object> map = model.asMap();
		
		String mb_name = (String)map.get("mb_name");
		String mb_email = (String)map.get("mb_email");
		
		dto = dao.selectId(mb_name, mb_email);

		String result = "";
		
		if(dto != null) {
			if (mb_name.equals(dto.getMb_name())) {
				result = dto.getMb_id().substring(0, 5) + dto.getMb_id().substring(5).replace(dto.getMb_id().substring(5), "*****");
			} 			
		}
		model.addAttribute("findId", result);
	}

}
