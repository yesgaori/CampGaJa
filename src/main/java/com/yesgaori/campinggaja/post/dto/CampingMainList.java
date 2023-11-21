package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CampingMainList {
	
	private int postId;
	private String title;
	private String userName;
	private int likeCount;
	private String thumbnailPath;
	private Date createdAt;

}
