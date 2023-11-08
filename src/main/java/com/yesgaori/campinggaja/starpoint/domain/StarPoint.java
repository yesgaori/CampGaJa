package com.yesgaori.campinggaja.starpoint.domain;

import java.sql.Date;

public class StarPoint {
	
	private int id;
	private int itemPostId;
	private int userId;
	private String content;
	private double starPoint;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemPostId() {
		return itemPostId;
	}
	public void setItemPostId(int itemPostId) {
		this.itemPostId = itemPostId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getStarPoint() {
		return starPoint;
	}
	public void setStarPoint(double starPoint) {
		this.starPoint = starPoint;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
