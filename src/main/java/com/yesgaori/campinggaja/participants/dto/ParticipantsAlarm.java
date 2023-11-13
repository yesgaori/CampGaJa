package com.yesgaori.campinggaja.participants.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParticipantsAlarm {

	private int participantsId;
	private int userId;
	private String title;
	private int personnel;
	private int approvePersonnel;
	private String content;
	private String loginId;
	private int age;
	private String kakao;
	private String qualifications;
	private String result;
	private String appointmentStartDate;
	private String appointmentEndDate;
	
}
