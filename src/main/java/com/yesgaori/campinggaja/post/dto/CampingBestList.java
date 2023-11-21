package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CampingBestList {
	
	private int postId;
	private int count;
	private String thumbNailPath;
	private String title;
	
}
