package com.yesgaori.campinggaja.post.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {
	
	public int creatDiaryPost(
				@Param("userId") int userId
				, @Param("title") String title
				, @Param("content") String content
				, @Param("imagePath") String imagePath
				, @Param("mapPath") String mapPath);
	
}
