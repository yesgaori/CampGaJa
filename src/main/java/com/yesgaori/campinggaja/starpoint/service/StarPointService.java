package com.yesgaori.campinggaja.starpoint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.campinggaja.starpoint.domain.BestStarPoint;
import com.yesgaori.campinggaja.starpoint.domain.StarPoint;
import com.yesgaori.campinggaja.starpoint.dto.StarPointDetail;
import com.yesgaori.campinggaja.starpoint.repository.StarPointRepository;
import com.yesgaori.campinggaja.user.domain.User;
import com.yesgaori.campinggaja.user.service.UserService;

@Service
public class StarPointService {
	
	@Autowired
	private StarPointRepository starPointRepository;
	@Autowired
	private UserService userService;
	
	public int countStarPoint(int postId) {
		return starPointRepository.selectCountStarPoint(postId);
	}
	
	public boolean isStarPoint(int postId, int userId) {
		
		int count = starPointRepository.selectCountStarPointByUserId(postId, userId);
		
//		if(count == 0) {
//			return false;
//			
//		} else {
//			return true;
//		}
		
		return count != 0;
	}
	
	public int addStarPoint(int userId, int itemPostId, String content, double starPoint) {
		
		return starPointRepository.insertStarPoint(userId, itemPostId, content, starPoint);
	}
	
	public List<BestStarPoint> selectCountList() {
		
		return starPointRepository.selectCountList();
		
	}
	
	
	public List<StarPointDetail> getStarPointList(int postId) {
		
		List<StarPoint> starPointList = starPointRepository.selectStarPointList(postId);
		
		List<StarPointDetail> starPointDetailList = new ArrayList<>();
		for(StarPoint starPoint:starPointList) {
			
			int userId = starPoint.getUserId();
			User user = userService.getUserById(userId);
			
			StarPointDetail starPointDetail = StarPointDetail.builder()
															.id(starPoint.getId())
															.userId(starPoint.getUserId())
															.content(starPoint.getContent())
															.loginId(user.getLoginId())
															.starPoint(starPoint.getStarPoint())
															.build();
		
			starPointDetailList.add(starPointDetail);
		}
		
		return starPointDetailList;
	}
	
	public int deleteStarPointByPostId(int postId) {
		return starPointRepository.deleteStarPointByPost(postId);
	}
	
	
}
