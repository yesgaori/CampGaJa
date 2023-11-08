package com.yesgaori.campinggaja.starpoint.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.campinggaja.starpoint.domain.StarPoint;

@Repository
public interface StarPointRepository {
	
	public int selectCountStarPoint(
			@Param("postId") int postId);
	
	public int selectCountStarPointByUserId(
			@Param("postId") int postId
			, @Param("userId") int userId);
	
	public int insertStarPoint(
			@Param("userId") int userId
			, @Param("itemPostId") int postId
			, @Param("content") String content
			, @Param("starPoint") double starPoint);
	
	public List<StarPoint> selectStarPointList(@Param("postId") int postId
											);
	
	
	public int deleteStarPointByPost(@Param("postId") int postId);
	
	
}
