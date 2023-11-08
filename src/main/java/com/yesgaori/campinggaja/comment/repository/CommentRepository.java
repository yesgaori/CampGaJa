package com.yesgaori.campinggaja.comment.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.campinggaja.comment.domain.Comment;

@Repository
public interface CommentRepository {
	
	public int insertComment(
			@Param("userId") int userId
			, @Param("postId") int postId
			, @Param("category") int category
			, @Param("content") String content);
	
	public List<Comment> selectCommentList(@Param("postId") int postId
											, @Param("category") int category);
	
	
	public int deleteCommentByPost(@Param("postId") int postId
									, @Param("category") int category);
	
}
