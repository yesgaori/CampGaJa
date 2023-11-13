package com.yesgaori.campinggaja.participants.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParticipantsDetail {
	
	private int participantsId;
	private int userId;
	private String content;
	private String loginId;
	private boolean isParticipants;
	private int age;
	private String kakao;
	private String qualifications;
	private String result;

	
}
