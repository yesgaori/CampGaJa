package com.yesgaori.campinggaja.starpoint.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StarPointDetail {

	private int id;
	private int userId;
	private String content;
	private String loginId;
	private double starPoint;

}
