package com.yesgaori.campinggaja.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yesgaori.campinggaja.like.service.LikeService;

@RequestMapping("/post")
@RestController
public class LikeRestController {

	@Autowired
	private LikeService likeService;
	
	@PostMapping("/like")
	public Map<String, String> like(
			@RequestParam("postId") int postId
			, @RequestParam("category") int category
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = likeService.addLike(postId, userId, category);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("reslut", "fail");
		}
		return resultMap;
		
	}
	
	@DeleteMapping("/unlike")
	public Map<String, String> unlike (
								@RequestParam("postId") int postId
								, @RequestParam("category") int category
								, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = likeService.deleteLikeByPostIdAndUserId(postId, userId, category);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
}
