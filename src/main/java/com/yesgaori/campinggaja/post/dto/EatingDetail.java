package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;
import java.util.List;

import com.yesgaori.campinggaja.comment.dto.CommentDetail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EatingDetail {
	
	private int id;
	private int userId;
	private String loginId;
	private String name;
	private String title;
	private String content;
	private int likeCount;
	private boolean isLike;
	private List<CommentDetail> commentList;
	private Date createdAt;
	
}
