package com.yesgaori.campinggaja.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yesgaori.campinggaja.comment.dto.CommentDetail;
import com.yesgaori.campinggaja.comment.service.CommentService;
import com.yesgaori.campinggaja.common.FileManager;
import com.yesgaori.campinggaja.like.service.LikeService;
import com.yesgaori.campinggaja.post.domain.CampingDiaryPost;
import com.yesgaori.campinggaja.post.dto.PostDetail;
import com.yesgaori.campinggaja.post.repository.PostRepository;
import com.yesgaori.campinggaja.user.domain.User;
import com.yesgaori.campinggaja.user.service.UserService;

@Service	
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private LikeService likeService;
	@Autowired
	private CommentService commentService;
	
	public int creatDiaryPost(int userId, String title, String content, String mapPath) {
		
		
		return postRepository.creatDiaryPost(userId, title, content, mapPath);
		
	}
	
	public String insertImage(int userId, MultipartFile file) {
		
		return FileManager.saveFile(userId, file);
		
		
		
	}
	
	public List<CampingDiaryPost> selectDiary() {
		
		return postRepository.selectDiary();
	}
	
	public CampingDiaryPost selectDetail(int id) {
		
		return postRepository.selectDetail(id);
	}
	
	public PostDetail getPost(int loginUserId
							, int id) {
		
		CampingDiaryPost post = postRepository.selectDetail(id);
			
		int userId = post.getUserId();
		User user = userService.getUserById(userId);
		// 좋아요 개수 조회
		int likeCount = likeService.countLike(post.getId());
		boolean isLike = likeService.isLike(post.getId(), loginUserId);
		
		
		List<CommentDetail> commentList = commentService.getCommentList(post.getId());
		
		PostDetail postDetail = PostDetail.builder()
								.id(post.getId())
								.userId(userId)
								.content(post.getContent())
								.mapPath(post.getMapPath())
								.loginId(user.getLoginId())
								.likeCount(likeCount)
								.isLike(isLike)
								.commentList(commentList)
								.build();
		
			

		
		return postDetail;
		
	}
	
	
}
