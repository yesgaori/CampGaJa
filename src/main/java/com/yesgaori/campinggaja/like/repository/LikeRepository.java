package com.yesgaori.campinggaja.like.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.campinggaja.like.domain.BestLike;

@Repository
public interface LikeRepository {

	
	public int insertLike(
			@Param("postId") int postId
			, @Param("userId") int userId
			, @Param("category") int category);
	
	public int selectCountLike(
			@Param("postId") int postId
			, @Param("category") int category);
	
	public int selectCountLikeByUserId(
			@Param("postId") int postId
			, @Param("userId") int userId
			, @Param("category") int category);
	
	public int deleteLikeByPostId(@Param("postId") int postId
								, @Param("category") int category);
	
	public int deleteLikeByPostIdAndUserId(
				@Param("postId") int postId
				, @Param("userId")int userId
				, @Param("category") int category);
	
	public List<BestLike> selectCountList(
								@Param("category") int category);
}
