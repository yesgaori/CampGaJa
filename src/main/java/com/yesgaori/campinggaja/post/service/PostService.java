package com.yesgaori.campinggaja.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yesgaori.campinggaja.common.FileManager;
import com.yesgaori.campinggaja.post.domain.CampingDiaryPost;
import com.yesgaori.campinggaja.post.repository.PostRepository;
import com.yesgaori.campinggaja.user.domain.User;

@Service	
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
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
	
	public User getUser(int id) {
		
		return 
	}
}
