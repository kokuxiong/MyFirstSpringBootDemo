package com.koku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private TeacherController teaCtrl;
	
	@RequestMapping({"/","/index","/koku/index"})
	public String showIndex() {
		//
		teaCtrl.setDeleteErrorMsg("");
		return "index";
	}
}
