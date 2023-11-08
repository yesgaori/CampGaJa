package com.yesgaori.campinggaja.like.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
	
	
}
