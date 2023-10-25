package com.yesgaori.campinggaja.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yesgaori.campinggaja.common.FileManager;
import com.yesgaori.campinggaja.post.repository.PostRepository;

@Service	
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public int creatDiaryPost(int userId, String title, String content, MultipartFile file, String mapPath) {
		
		String imagePath = FileManager.saveFile(userId, file);
		
		return postRepository.creatDiaryPost(userId, title, content, imagePath, mapPath);
		
	}
	
	
}
