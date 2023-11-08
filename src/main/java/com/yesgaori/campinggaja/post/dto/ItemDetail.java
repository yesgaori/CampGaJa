package com.yesgaori.campinggaja.post.dto;

import java.sql.Date;
import java.util.List;

import com.yesgaori.campinggaja.starpoint.dto.StarPointDetail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDetail {
	
	private int id;
	private int userId;
	private int loginId;
	private String name;
	private String title;
	private String content;
	private double point;
	private double averagePoint;
	private int starPointCount;
	private boolean isStarPoint;
	private List<StarPointDetail> starPointList;
	private Date createdAt;
	
}
