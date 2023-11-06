package com.yesgaori.campinggaja.post;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yesgaori.campinggaja.post.domain.CampingDiaryPost;
import com.yesgaori.campinggaja.post.dto.PostDetail;
import com.yesgaori.campinggaja.post.service.PostService;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	private PostService postService;

	@GetMapping("/main-view")
	public String timeLine() {
		
		return "/post/main";
	}
	
	
	@GetMapping("/camping-diary/create-view")
	public String diaryCreateView() {
		
		return"/post/diaryInput";
	}
	
	@GetMapping("/main/diary-view")
	public String diaryMainView(Model model) {
			
	List<CampingDiaryPost> diaryList = postService.selectDiary();
	
	model.addAttribute("diaryList", diaryList);
		
		return"/post/diaryMain";
	}
	
	@GetMapping("/camping-diary/detail-view")
	public String postDetail(@RequestParam("id") int id
							, Model model
							, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		PostDetail postList = postService.getPost(userId, id);
		
		model.addAttribute("postList", postList);
		
		return "post/diaryDetail";
	}
	
}
