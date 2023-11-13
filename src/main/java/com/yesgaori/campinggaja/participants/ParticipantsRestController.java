package com.yesgaori.campinggaja.participants;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yesgaori.campinggaja.participants.service.ParticipantsService;

@RequestMapping("/post")
@RestController
public class ParticipantsRestController {
	
	@Autowired
	private ParticipantsService participantsService;
	
	@RequestMapping(value="/participants", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, String> createParticipants(
											@RequestParam("recruitmentPostId") int recruitmentPostId
											, @RequestParam("content") String content
											, @RequestParam("age") int age
											, @RequestParam("kakao") String kakao
											, @RequestParam("qualifications") String qualifications
											, @RequestParam("result") String result
											, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = participantsService.addParticipants(recruitmentPostId, userId, content, age, kakao, qualifications, result);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@DeleteMapping("/recruitment/participation/reject")
	public Map<String, String> rejectParticipants(
												@RequestParam("participantsId")int participantsId) {
		
		int count = participantsService.deleteParticipantsByPostId(participantsId);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			
			result.put("result", "success");
		} else {
			
			result.put("result", "fail");
		}
		
		return result;
	}
}
