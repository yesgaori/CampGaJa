package com.yesgaori.campinggaja.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@GetMapping("/main-view")
	public String timeLine() {
		
		return "/post/main";
	}
	
	
	@GetMapping("/camping-diary/create-view")
	public String diaryCreateView() {
		
		return"/post/diaryInput";
	}
}
