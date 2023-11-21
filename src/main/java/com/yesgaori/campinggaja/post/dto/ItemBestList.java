package com.yesgaori.campinggaja.post.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemBestList {
	
	private int postId;
	private int count;
	private String thumbNailPath;
	private String title;
	
	
}
