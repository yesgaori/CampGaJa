package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecruitmentMainList {
	
	private int postId;
	private String title;
	private String userName;
	private int info;
	private int personnel;
	private int personnelCount;
	private int participants;
	private String mapPath;
	private String startDate;
	private String endDate;
	private Date createdAt;
	
		
}
