package com.yesgaori.campinggaja.post.repository;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.campinggaja.post.domain.CampingDiaryPost;
import com.yesgaori.campinggaja.post.domain.EatingDiaryPost;
import com.yesgaori.campinggaja.post.domain.ItemPost;
import com.yesgaori.campinggaja.post.domain.RecruitmentPost;

@Repository
public interface PostRepository {
	
	public int creatDiaryPost(
				@Param("userId") int userId
				, @Param("title") String title
				, @Param("content") String content
				, @Param("mapPath") String mapPath);
	
	
	public List<CampingDiaryPost> selectDiary();
	
	public CampingDiaryPost selectDetail(@Param("id") int id);
	
	public int creatEatingPost(
			@Param("userId") int userId
			, @Param("title") String title
			, @Param("content") String content);


	public List<EatingDiaryPost> selectEatingList();
	
	public EatingDiaryPost selectEating(@Param("id") int id);
	
	public int creatItemPost(
			@Param("userId") int userId
			, @Param("title") String title
			, @Param("content") String content
			, @Param("starPoint") double starPoint);


	public List<ItemPost> selectItemList();
	
	public ItemPost selectItem(@Param("id") int id);
	
	
	public int creatRecruitment(
			@Param("userId") int userId
			, @Param("title") String title
			, @Param("content") String content
			, @Param("mapPath") String mapPath
			, @Param("personnel") int personnel
			, @Param("appointmentStartDate") String appointmentStartDate
			, @Param("appointmentEndDate") String appointmentEndDate
			, @Param("info") int info);


	public List<RecruitmentPost> selectRecruitmentList();
	
	public RecruitmentPost selectRecruitment(@Param("id") int id);
	
	public List<RecruitmentPost> findRecruitmentPostList(@Param("userId") int userId);
	
	}
