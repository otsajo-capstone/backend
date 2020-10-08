package com.otsazo.colorfit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.otsazo.colorfit.beans.DressDTO;
import com.otsazo.colorfit.command.SaveLinkResultCommand;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	
	@RequestMapping("/choose")
	public String choose(Model model) {
		return "/analysis/choose";
	}
	
	@RequestMapping("/link")
	public String link(Model model) {
		return "/analysis/link";
	}
	
	@RequestMapping("/linkResult")
	public String linkResult(Model model) {
		return "/analysis/linkResult";
	}
	
	@RequestMapping("/saveLinkResult")
	public String linkResult(DressDTO dto, @RequestParam("dressImg") MultipartFile dressImg, Model model) {
		model.addAttribute("dto", dto);
		model.addAttribute("dressImg", dressImg);
		new SaveLinkResultCommand().execute(model);
		return "/analysis/saveLinkResult";
	}
	
}
