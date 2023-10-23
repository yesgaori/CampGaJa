package com.yesgaori.campinggaja.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/user/login-view";
		
	}
	
	@GetMapping("/login-view")
	public String login() {
		
		return "/user/login";
	}
	
	@GetMapping("/join-view")
	public String join() {
		
		return "/user/join";
	}
	
}
