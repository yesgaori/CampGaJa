package com.yesgaori.campinggaja.starpoint;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yesgaori.campinggaja.starpoint.service.StarPointService;

@RequestMapping("/post")
@RestController
public class StarPointRestController {
	
	@Autowired
	private StarPointService starPointService;
	
	@PostMapping("/star-point")
	public Map<String, String> createStarPoint(
			@RequestParam("itemPostId") int postId
			, @RequestParam("content") String content
			, @RequestParam("starPoint") double starPoint
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		int count = starPointService.addStarPoint(userId, postId, content, starPoint);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
}
