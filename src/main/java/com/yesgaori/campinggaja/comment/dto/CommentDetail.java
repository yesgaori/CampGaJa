package com.yesgaori.campinggaja.comment.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDetail {
	
	private int id;
	private int userId;
	private String content;
	private String loginId;
	
	
}
