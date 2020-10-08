package com.otsazo.colorfit.command;


import java.util.Map;

import org.springframework.ui.Model;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.beans.dao.MemberDAO;

public class MypageCommand implements Command{

	@Override
	public void execute(Model model) {
		//int mb_uid = (Integer)model.getAttribute("mb_uid");
		Map<String, Object> map = model.asMap();
		int mb_uid = (Integer)map.get("mb_uid");
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		MemberDTO dto = dao.selectMemberByUid(mb_uid);
		model.addAttribute("dto", dto);
	}

}
