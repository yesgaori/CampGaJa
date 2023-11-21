package com.yesgaori.campinggaja.participants;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yesgaori.campinggaja.participants.dto.ParticipantsAlarm;
import com.yesgaori.campinggaja.participants.service.ParticipantsService;
import com.yesgaori.campinggaja.post.domain.RecruitmentPost;

@Controller
@RequestMapping("/post")
public class ParticipantsController {
	
	@Autowired
	private ParticipantsService participantsService;
	
	@GetMapping("/recruitment/participants-view")
	public String creatParticipants(
									int postId
									, Model model) {
		
		RecruitmentPost result = participantsService.findPostid(postId);

		model.addAttribute("post", result);
		
		return "/post/participantsInput";
	}
	
	@GetMapping("/alarm-view")
	public String alarmView(
							Model model
			 				, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<ParticipantsAlarm> result = participantsService.getParticipantsPostList(userId);
		

		
		model.addAttribute("postList", result);
		
		return "/post/alarm";
	}
}
