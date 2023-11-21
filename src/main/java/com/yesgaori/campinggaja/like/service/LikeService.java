package com.yesgaori.campinggaja.like.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.campinggaja.like.domain.BestLike;
import com.yesgaori.campinggaja.like.repository.LikeRepository;

@Service
public class LikeService {

	
	@Autowired
	private LikeRepository likeRepository;
	
	public int addLike(int postId, int userId, int category) {
		return likeRepository.insertLike(postId, userId, category);
	}
	
	public int countLike(int postId, int category) {
		return likeRepository.selectCountLike(postId, category);
	}
	
	public List<BestLike> selectCountList(int category){
		
		return likeRepository.selectCountList(category);
		
	}
	
	public boolean isLike(int postId, int userId, int category) {
		
		int count = likeRepository.selectCountLikeByUserId(postId, userId, category);
		
//		if(count == 0) {
//			return false;
//			
//		} else {
//			return true;
//		}
		
		return count != 0;
	}
	
	public int deleteLikeByPostId(int postId, int category) {
		return likeRepository.deleteLikeByPostId(postId, category);
	}
	
	public int deleteLikeByPostIdAndUserId(int postId, int userId, int category) {
		
		return likeRepository.deleteLikeByPostIdAndUserId(postId, userId, category);
		
	}
	
}
