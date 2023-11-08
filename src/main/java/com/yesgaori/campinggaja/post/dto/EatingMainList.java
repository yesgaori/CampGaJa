package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EatingMainList {
	
	private int postId;
	private String title;
	private String userName;
	private int likeCount;
	private Date createdAt;
	
}
