package com.yesgaori.campinggaja.post.service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yesgaori.campinggaja.comment.dto.CommentDetail;
import com.yesgaori.campinggaja.comment.service.CommentService;
import com.yesgaori.campinggaja.common.FileManager;
import com.yesgaori.campinggaja.like.service.LikeService;
import com.yesgaori.campinggaja.participants.dto.ParticipantsDetail;
import com.yesgaori.campinggaja.participants.service.ParticipantsService;
import com.yesgaori.campinggaja.post.domain.CampingDiaryPost;
import com.yesgaori.campinggaja.post.domain.EatingDiaryPost;
import com.yesgaori.campinggaja.post.domain.ItemPost;
import com.yesgaori.campinggaja.post.domain.RecruitmentPost;
import com.yesgaori.campinggaja.post.dto.CampingMainList;
import com.yesgaori.campinggaja.post.dto.EatingDetail;
import com.yesgaori.campinggaja.post.dto.EatingMainList;
import com.yesgaori.campinggaja.post.dto.ItemDetail;
import com.yesgaori.campinggaja.post.dto.ItemMainList;
import com.yesgaori.campinggaja.post.dto.PostDetail;
import com.yesgaori.campinggaja.post.dto.RecruitmentDetail;
import com.yesgaori.campinggaja.post.dto.RecruitmentMainList;
import com.yesgaori.campinggaja.post.repository.PostRepository;
import com.yesgaori.campinggaja.starpoint.dto.StarPointDetail;
import com.yesgaori.campinggaja.starpoint.service.StarPointService;
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
	@Autowired
	private StarPointService starPointService;
	@Autowired
	private ParticipantsService participantsService;
	
	public int creatDiaryPost(int userId, String title, String content, String mapPath) {
		
		
		return postRepository.creatDiaryPost(userId, title, content, mapPath);
		
	}
	
	public String insertImage(int userId, MultipartFile file) {
		
		return FileManager.saveFile(userId, file);
		
		
		
	}
	
	public List<CampingMainList> selectDiary() {
		
		List<CampingMainList> campingMain = new ArrayList<>(); 
		List<CampingDiaryPost> campingDiaryPostList = postRepository.selectDiary();
		
		for(CampingDiaryPost campingDiaryPost:campingDiaryPostList) {
		
			int count = likeService.countLike(campingDiaryPost.getId(), 1);
			
				
			User user = userService.getUserById(campingDiaryPost.getUserId());
			
			CampingMainList campingMainList = CampingMainList.builder()
										.postId(campingDiaryPost.getId())
										.title(campingDiaryPost.getTitle())
										.userName(user.getName())
										.likeCount(count)
										.createdAt(campingDiaryPost.getCreatedAt())
										.build();
			
			campingMain.add(campingMainList);
		}
			return campingMain;
	}
	
	public CampingDiaryPost selectDetail(int id) {
		
		return postRepository.selectDetail(id);
	}
	
	public PostDetail getPost(int loginUserId
							, int id
							, int category) {
		
		CampingDiaryPost post = postRepository.selectDetail(id);
			
		int userId = post.getUserId();
		User user = userService.getUserById(userId);
		int likeCount = likeService.countLike(post.getId(), 1);
		boolean isLike = likeService.isLike(post.getId(), loginUserId, 1);
		
		
		List<CommentDetail> commentList = commentService.getCommentList(post.getId(), category);
		
		PostDetail postDetail = PostDetail.builder()
								.id(post.getId())
								.userId(userId)
								.name(user.getName())
								.title(post.getTitle())
								.content(post.getContent())
								.mapPath(post.getMapPath())
								.loginId(user.getLoginId())
								.likeCount(likeCount)
								.isLike(isLike)
								.commentList(commentList)
								.createdAt(post.getCreatedAt())
								.build();
		
			

		
		return postDetail;
		
	}
	
	public int creatEatingPost(int userId, String title, String content) {
		
		
		return postRepository.creatEatingPost(userId, title, content);
		
	}
	
	
	public List<EatingMainList> selectEatingList() {
		
		List<EatingMainList> eatingMain = new ArrayList<>(); 
		List<EatingDiaryPost> eatingDiaryPostList = postRepository.selectEatingList();
		
		for(EatingDiaryPost eatingDiaryPost:eatingDiaryPostList) {
		
			int count = likeService.countLike(eatingDiaryPost.getId(),2);
			
				
			User user = userService.getUserById(eatingDiaryPost.getUserId());
			
			EatingMainList eatingMainList = EatingMainList.builder()
										.postId(eatingDiaryPost.getId())
										.title(eatingDiaryPost.getTitle())
										.userName(user.getName())
										.likeCount(count)
										.createdAt(eatingDiaryPost.getCreatedAt())
										.build();
			
			eatingMain.add(eatingMainList);
		}
			return eatingMain;
	}
		
	public EatingDiaryPost selectEating(int id) {
		
		return postRepository.selectEating(id);
	}
	
	public EatingDetail getEating(int loginUserId
							, int id
							, int category) {
		
		EatingDiaryPost post = postRepository.selectEating(id);
			
		int userId = post.getUserId();
		User user = userService.getUserById(userId);
		int likeCount = likeService.countLike(post.getId(), 2);
		boolean isLike = likeService.isLike(post.getId(), loginUserId, 2);
		
		
		List<CommentDetail> commentList = commentService.getCommentList(post.getId(), category);
		
		EatingDetail eatingDetail = EatingDetail.builder()
								.id(post.getId())
								.userId(userId)
								.name(user.getName())
								.title(post.getTitle())
								.content(post.getContent())
								.loginId(user.getLoginId())
								.likeCount(likeCount)
								.isLike(isLike)
								.commentList(commentList)
								.createdAt(post.getCreatedAt())
								.build();
		
			

		
		return eatingDetail;
		
	}
	
	public int creatItemPost(int userId, String title, String content, double starPoint) {
		
		
		return postRepository.creatItemPost(userId, title, content, starPoint);
		
	}
	
	
	public List<ItemMainList> selectItemList() {
		
		double averagePoint = 0.0;
		List<ItemMainList> itemMain = new ArrayList<>(); 
		List<ItemPost> itemList = postRepository.selectItemList();
		
		for(ItemPost itemPost:itemList) {
		
			List<StarPointDetail> starPointList = starPointService.getStarPointList(itemPost.getId());
			
				for(StarPointDetail starPointDetail:starPointList) {
					
					averagePoint =+ starPointDetail.getStarPoint();
					
				}
			int starPointCount = starPointService.countStarPoint(itemPost.getId());
				
			User user = userService.getUserById(itemPost.getUserId());
			
			ItemMainList itemMainList = ItemMainList.builder()
										.postId(itemPost.getId())
										.title(itemPost.getTitle())
										.userName(user.getName())
										.averagePoint((averagePoint + itemPost.getStarPoint())/(starPointCount + 1))
										.createdAt(itemPost.getCreatedAt())
										.build();
			
			itemMain.add(itemMainList);
			averagePoint = 0.0;
		}
		
		return itemMain;
		
		
	}
	
	public ItemPost selectItem(int id) {
		
		return postRepository.selectItem(id);
	}
	
	public ItemDetail getItem(int loginUserId
							, int id) {
		
		ItemPost post = postRepository.selectItem(id);
			
		int userId = post.getUserId();
		User user = userService.getUserById(userId);
		int starPointCount = starPointService.countStarPoint(post.getId());
		boolean isStarPoint = starPointService.isStarPoint(post.getId(), loginUserId);
		
		
		List<StarPointDetail> starPointList = starPointService.getStarPointList(post.getId());
		
		double averagePoint = 0.0;
		
		for(StarPointDetail starPoint:starPointList){
			
			averagePoint =+ (double)starPoint.getStarPoint();
		};
		
		ItemDetail itemDetail = ItemDetail.builder()
								.id(post.getId())
								.userId(userId)
								.name(user.getName())
								.title(post.getTitle())
								.content(post.getContent())
								.point(post.getStarPoint())
								.loginId(loginUserId)
								.averagePoint((averagePoint + post.getStarPoint())/(starPointCount + 1))
								.starPointCount(starPointCount)
								.isStarPoint(isStarPoint)
								.starPointList(starPointList)
								.createdAt(post.getCreatedAt())
								.build();
		
			

		
		return itemDetail;
		
	}
	
	public int creatRecruitmentPost(
									int userId
									, String title
									, String content
									, String mapPath
									, int personnel
									, String appointmentStartDate
									, String appointmentEndDate
									, int info) {
		
		
		return postRepository.creatRecruitment(
													userId
													, title
													, content
													, mapPath
													, personnel
													, appointmentStartDate
													, appointmentEndDate
													, info);
		
	}
	
	
	public List<RecruitmentMainList> selectRecruitmentList() {
		
		List<RecruitmentMainList> recruitmentMain = new ArrayList<>(); 
		List<RecruitmentPost> recruitmentList = postRepository.selectRecruitmentList();
		
		for(RecruitmentPost post:recruitmentList) {
		
				
			User user = userService.getUserById(post.getUserId());
			
			int approveCount = participantsService.approveCountParticipants(post.getId());
			int participants = participantsService.countParticipants(post.getId());
			RecruitmentMainList recruitmentMainList = RecruitmentMainList.builder()
													.postId(post.getId())
													.title(post.getTitle())
													.userName(user.getName())
													.info(post.getInfo())
													.personnel(post.getPersonnel())
													.personnelCount(approveCount)
													.participants(participants)
													.mapPath(post.getMapPath())
													.startDate(post.getAppointmentStartDate())
													.endDate(post.getAppointmentEndDate())
													.createdAt(post.getCreatedAt())
													.build();
			
			recruitmentMain.add(recruitmentMainList);
			
		}
		
		return recruitmentMain;
		
		
	}
	
	public RecruitmentPost selectRecruitment(int id) {
		
		return postRepository.selectRecruitment(id);
	}
	
	public RecruitmentDetail getRecruitment(
											int loginUserId
											, int id) {
		
		RecruitmentPost post = postRepository.selectRecruitment(id);
			
		int userId = post.getUserId();
		User user = userService.getUserById(userId);
		
		int participantsCount = participantsService.countParticipants(post.getId());
		int approveCount = participantsService.approveCountParticipants(post.getId());
		boolean isParticipants = participantsService.isParticipants(post.getId(), loginUserId);
		
		
		List<ParticipantsDetail> participantsList = participantsService.getParticipantsList(post.getId());
		
		RecruitmentDetail recruitmentDetail = RecruitmentDetail.builder()
											.id(post.getId())
											.userId(userId)
											.loginId(loginUserId)
											.name(user.getName())
											.title(post.getTitle())
											.content(post.getContent())
											.info(post.getInfo())
											.confirm(isParticipants)
											.participantsCount(participantsCount)
											.personnel(post.getPersonnel())
											.personnelCount(approveCount)
											.startDate(post.getAppointmentStartDate())
											.endDate(post.getAppointmentEndDate())
											.mapPath(post.getMapPath())
											.createdAt(post.getCreatedAt())
											.build();

			
	
		return recruitmentDetail;
		
	}
}
