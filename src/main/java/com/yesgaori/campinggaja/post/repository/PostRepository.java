package com.yesgaori.campinggaja.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.campinggaja.post.domain.CampingDiaryPost;

@Repository
public interface PostRepository {
	
	public int creatDiaryPost(
				@Param("userId") int userId
				, @Param("title") String title
				, @Param("content") String content
				, @Param("mapPath") String mapPath);
	
	
	public List<CampingDiaryPost> selectDiary();
	
	public CampingDiaryPost selectDetail(@Param("id") int id);
	
}
