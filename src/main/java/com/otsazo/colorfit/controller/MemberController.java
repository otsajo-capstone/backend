package com.otsazo.colorfit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.otsazo.colorfit.beans.MemberDTO;
import com.otsazo.colorfit.command.LoginCommand;
import com.otsazo.colorfit.command.MbFindIdOkCommand;
import com.otsazo.colorfit.command.MbFindPwOkCommand;
import com.otsazo.colorfit.command.SignUpOkCommand;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/findIdPw")
	public String findIdPw(Model model) {
		return "/member/findIdPw";
	}
	
	@RequestMapping("/findIdOk")
	public String findIdOk(String mb_name, String mb_email, Model model) {
		model.addAttribute("nav", 0);
		model.addAttribute("mb_name", mb_name);
		model.addAttribute("mb_email", mb_email);
		new MbFindIdOkCommand().execute(model);
		return "/member/findIdOk";
	}
	
	@RequestMapping("/findPwOk")
	public String findPwOk(String mb_id, String mb_name, String mb_email, Model model) {
		model.addAttribute("nav", 0);
		model.addAttribute("mb_id", mb_id);
		model.addAttribute("mb_name", mb_name);
		model.addAttribute("mb_email", mb_email);
		new MbFindPwOkCommand().execute(model);
		return "/member/findPwOk";
	}
	
	@RequestMapping("/signUp")
	public String signUp(Model model) {
		return "/member/signUp";
	}
	
	@RequestMapping("/signUpCustomerOk")
	public String signUpCustomerOk(MemberDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new SignUpOkCommand().execute(model);
		return "/member/signUpOk";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "/member/login";
	}

	@RequestMapping("/loginOk")
	public String loginOk(Model model, String mb_id, String mb_pw, HttpSession session) {
		model.addAttribute("mb_id", mb_id);
		model.addAttribute("mb_pw", mb_pw);
		new LoginCommand().execute(model);
		int mb_uid = (Integer)model.getAttribute("mb_uid");
		if(mb_uid != 0) {
			session.setAttribute("mb_uid", mb_uid);
		}
		System.out.println((Integer)session.getAttribute("mb_uid"));
		return "/member/loginOk";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/member/logout";
	}
}
