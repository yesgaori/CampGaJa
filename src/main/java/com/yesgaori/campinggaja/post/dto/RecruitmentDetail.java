package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;
import java.util.List;

import com.yesgaori.campinggaja.starpoint.dto.StarPointDetail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecruitmentDetail {
	
	private int id;
	private int userId;
	private int loginId;
	private String name;
	private String title;
	private String content;
	private int info;
	private boolean confirm;
	private int participantsCount;
	private int personnel;
	private int personnelCount;
	private String startDate;
	private String endDate;
	private String mapPath;
	private Date createdAt;
	
	
}
