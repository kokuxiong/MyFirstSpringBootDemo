package com.koku.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private TeacherController teaCtrl;
	
	@RequestMapping({"/","/index","/koku/index"})
	public String showIndex(HttpServletRequest httpServletRequest,Model model) {
		//delete teacher error message init
		teaCtrl.setDeleteErrorMsg("");
		//get auth from session
		HttpSession session = httpServletRequest.getSession(false);
		//set auth to model
		model.addAttribute("auth", session.getAttribute("auth"));
		return "index";
	}
}
