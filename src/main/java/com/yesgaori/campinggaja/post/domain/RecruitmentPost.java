package com.yesgaori.campinggaja.post.domain;

import java.sql.Date;

public class RecruitmentPost {
	
	
	private int id;
	private int userId;
	private String title;
	private String content;
	private String mapPath;
	private int personnel;
	private String appointmentStartDate;
	private String appointmentEndDate;
	private int info;
	private String thumbnailPath;
	private Date createdAt;
	private Date updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMapPath() {
		return mapPath;
	}
	public void setMapPath(String mapPath) {
		this.mapPath = mapPath;
	}
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	public String getAppointmentStartDate() {
		return appointmentStartDate;
	}
	public void setAppointmentStartDate(String appointmentStartDate) {
		this.appointmentStartDate = appointmentStartDate;
	}
	public String getAppointmentEndDate() {
		return appointmentEndDate;
	}
	public void setAppointmentEndDate(String appointmentEndDate) {
		this.appointmentEndDate = appointmentEndDate;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
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
