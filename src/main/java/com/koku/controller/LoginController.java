package com.koku.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koku.pojo.User;
import com.koku.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping({"/login","/koku/login"})
	public String doLogin() {
		return "login";
	}
	
	@PostMapping({"/login","/koku/login"})
	public String doLogin(HttpServletRequest request,@PathParam("userName") String userName,@PathParam("password") String password,Model model) {
		
		User user = userService.findUserByUsername(userName);
		
		if(user.getUsername().equals(userName) && user.getPassword().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userName", user.getUsername());
			session.setMaxInactiveInterval(1800);
			return "index";
		}
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String doLogout(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession(false);
		if(session != null) {
			session.removeAttribute("userName");
		}
		return "login";
	}
}
