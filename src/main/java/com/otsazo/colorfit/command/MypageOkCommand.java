package com.otsazo.colorfit.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.beans.PasswordEncoding;
import com.otsazo.colorfit.beans.dao.MemberDAO;

public class MypageOkCommand implements Command {

	@Override
	public void execute(Model model) {
		int cnt = 0;
		PasswordEncoding pe = new PasswordEncoding();
		
		Map<String, Object> map = model.asMap();
		MemberDTO dto = (MemberDTO)map.get("dto");
		dto.setMb_pw(pe.encode(dto.getMb_pw()));

		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);		
		cnt = dao.updateMemberByUid(dto);

		model.addAttribute("result", cnt);
	}

}
