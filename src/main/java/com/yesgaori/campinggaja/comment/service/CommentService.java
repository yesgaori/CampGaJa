package com.yesgaori.campinggaja.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.campinggaja.comment.domain.Comment;
import com.yesgaori.campinggaja.comment.dto.CommentDetail;
import com.yesgaori.campinggaja.comment.repository.CommentRepository;
import com.yesgaori.campinggaja.user.domain.User;
import com.yesgaori.campinggaja.user.service.UserService;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserService userService;
	
	public int addComment(int userId, int postId,int category, String content) {
		
		return commentRepository.insertComment(userId, postId, category, content);
	}
	
	
	public List<CommentDetail> getCommentList(int postId, int category) {
		
		List<Comment> commentList = commentRepository.selectCommentList(postId, category);
		
		List<CommentDetail> commentDetailList = new ArrayList<>();
		for(Comment comment:commentList) {
			
			int userId = comment.getUserId();
			User user = userService.getUserById(userId);
			
			CommentDetail commentDetail = CommentDetail.builder()
															.id(comment.getId())
															.userId(comment.getUserId())
															.category(comment.getCategory())
															.content(comment.getContent())
															.loginId(user.getLoginId())
															.build();
		
			commentDetailList.add(commentDetail);
		}
		
		return commentDetailList;
	}
	
	public int deleteCommentByPostId(int postId, int category) {
		return commentRepository.deleteCommentByPost(postId, category);
	}
	
}
