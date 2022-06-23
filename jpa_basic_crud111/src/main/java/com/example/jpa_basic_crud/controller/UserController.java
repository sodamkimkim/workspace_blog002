package com.example.jpa_basic_crud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private HttpSession httpSession;
	
	//../blogcrud/user/login_form
	@GetMapping("/login_form")
	public String loginForm() {
		return "user/login_form";
	}
	//../blogcrud/user/join_form
	@GetMapping("/join_form")
	public String joinForm() {
		return "user/join_form";
	}
		
	//../blogcrud/user/logout
	@GetMapping("/logout")
	public String logout() {
		//세션정보를 제거.(로그아웃 처리)
		httpSession.invalidate();
		return "redirect:/";
	}
}
