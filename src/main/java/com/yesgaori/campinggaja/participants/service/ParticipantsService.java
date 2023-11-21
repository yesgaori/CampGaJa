package com.yesgaori.campinggaja.participants.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.campinggaja.participants.domain.BestParticipants;
import com.yesgaori.campinggaja.participants.domain.RecruitmentParticipants;
import com.yesgaori.campinggaja.participants.dto.ParticipantsAlarm;
import com.yesgaori.campinggaja.participants.dto.ParticipantsDetail;
import com.yesgaori.campinggaja.participants.repository.ParticipantsRepository;
import com.yesgaori.campinggaja.post.domain.RecruitmentPost;
import com.yesgaori.campinggaja.post.repository.PostRepository;
import com.yesgaori.campinggaja.user.domain.User;
import com.yesgaori.campinggaja.user.service.UserService;

@Service
public class ParticipantsService {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ParticipantsRepository participantsRepository;
	@Autowired
	private PostRepository postRepository;
	
	public int countParticipants(int RecruitmentPostId) {
		return participantsRepository.selectCountParticipants(RecruitmentPostId);
	}
	
	public int approveCountParticipants(int RecruitmentPostId) {
		return participantsRepository.approveCountParticipants(RecruitmentPostId);
	}
	
	public boolean isParticipants(int recruitmentPostId, int userId) {
		
		int count = participantsRepository.selectCountParticipantsByUserId(recruitmentPostId, userId);
		
//		if(count == 0) {
//			return false;
//			
//		} else {
//			return true;
//		}
		
		return count != 0;
	}
	
	public int addParticipants(
							int recruitmentPostId
							, int userId
							, String content
							, int age
							, String kakao
							, String qualifications
							, String result) {
		
		return participantsRepository.insertParticipants(
														recruitmentPostId
														, userId
														, content
														, age
														, kakao
														, qualifications
														, result);
	}
	
	
	public List<ParticipantsDetail> getParticipantsList(int postId) {
		
		List<RecruitmentParticipants> participantsList = participantsRepository.selectParticipantsList(postId);
		
		List<ParticipantsDetail> participantsDetailList = new ArrayList<>();
		for(RecruitmentParticipants participants:participantsList) {
			
			int userId = participants.getUserId();
			User user = userService.getUserById(userId);
			int count = participantsRepository.selectCountParticipantsByUserId(postId, userId);
			
			boolean confirm; 
			
			if(0 != count) {
				confirm = true;
			} else {
				confirm = false;
			}
			
			ParticipantsDetail participantsDetail = ParticipantsDetail.builder()
															.participantsId(participants.getId())
															.userId(participants.getUserId())
															.content(participants.getContent())
															.loginId(user.getLoginId())
															.isParticipants(confirm)
															.age(participants.getAge())
															.kakao(participants.getKakao())
															.qualifications(participants.getQualifications())
															.result(participants.getResult())
															.build();
		
			participantsDetailList.add(participantsDetail);
		}
		
		return participantsDetailList;
	}
	
	public int deleteParticipantsByPostId(int participantsId) {
		return participantsRepository.deleteParticipantsByPost(participantsId);
	}
	
	public RecruitmentPost findPostid(int id) {
		
		return postRepository.selectRecruitment(id);
	}
	
	public List<ParticipantsAlarm> getParticipantsPostList(int userId) {
		
		List<RecruitmentPost> recruitmentList = postRepository.findRecruitmentPostList(userId);
		
		List<ParticipantsAlarm> participantsAlarmList = new ArrayList<>();
		for(RecruitmentPost post:recruitmentList) {
			
			
			User user = userService.getUserById(userId);

			

			
			List<RecruitmentParticipants> participantsList = participantsRepository.selectParticipantsList(post.getId());
			
			for(RecruitmentParticipants participants:participantsList) {
				
				int approveCount = participantsRepository.approveCountParticipants(post.getId());
				
				ParticipantsAlarm participantsAlarm = ParticipantsAlarm.builder()
														.participantsId(participants.getId())
														.userId(participants.getUserId())
														.title(post.getTitle())
														.personnel(post.getPersonnel())
														.approvePersonnel(approveCount)
														.content(participants.getContent())
														.loginId(user.getLoginId())
														.age(participants.getAge())
														.kakao(participants.getKakao())
														.qualifications(participants.getQualifications())
														.result(participants.getResult())
														.appointmentStartDate(post.getAppointmentStartDate())
														.appointmentEndDate(post.getAppointmentEndDate())
														.build();

				participantsAlarmList.add(participantsAlarm);
				
			}

		}
		
		return participantsAlarmList;
	}
	
	public List<BestParticipants> selectCountList(){
		
		return participantsRepository.selectCountList();
	}

}
