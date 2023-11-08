package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemMainList {
	
	private int postId;
	private String title;
	private String userName;
	private double averagePoint;
	private Date createdAt;
	
}
