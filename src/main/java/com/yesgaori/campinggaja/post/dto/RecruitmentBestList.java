package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecruitmentBestList {
	
	private int recruitmentPostId;
	private int count;
	private String thumbNailPath;
	private String title;
	
}
