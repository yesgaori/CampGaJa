package com.yesgaori.campinggaja.participants.domain;

import java.sql.Date;

public class RecruitmentParticipants {
	
	private int id;
	private int recruitmentPostId;
	private int userId;
	private String content;
	private int age;
	private String kakao;
	private String qualifications;
	private String result;
	private Date createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecruitmentPostId() {
		return recruitmentPostId;
	}
	public void setRecruitmentPostId(int recruitmentPostId) {
		this.recruitmentPostId = recruitmentPostId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getKakao() {
		return kakao;
	}
	public void setKakao(String kakao) {
		this.kakao = kakao;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
