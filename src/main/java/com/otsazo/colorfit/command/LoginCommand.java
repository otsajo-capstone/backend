package com.otsazo.colorfit.command;

import org.springframework.ui.Model;

import com.otsazo.colorfit.beans.C;
import com.otsazo.colorfit.beans.PasswordEncoding;
import com.otsazo.colorfit.beans.dao.MemberDAO;


public class LoginCommand implements Command {

	@Override
	public void execute(Model model) {
		PasswordEncoding pe = new PasswordEncoding();
		String mb_id = (String)model.getAttribute("mb_id");
		String mb_pw = (String)model.getAttribute("mb_pw");
		MemberDAO dao = C.sqlSession.getMapper(MemberDAO.class);
		if(pe.matches(mb_pw, dao.selectPwById(mb_id))) {
			int mb_uid = dao.selectUidById(mb_id);
			model.addAttribute("mb_uid", mb_uid);
		}else {
			model.addAttribute("mb_uid", 0);
		}
	}

}
