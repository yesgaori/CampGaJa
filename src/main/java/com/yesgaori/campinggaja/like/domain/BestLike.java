package com.yesgaori.campinggaja.like.domain;

import javax.persistence.Column;

public class BestLike {
	@Column(name="postId")
	private int postId;
	@Column(name="count")
	private int count;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
