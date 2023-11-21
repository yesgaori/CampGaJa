package com.yesgaori.campinggaja.post;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yesgaori.campinggaja.post.dto.CampingBestList;
import com.yesgaori.campinggaja.post.dto.CampingMainList;
import com.yesgaori.campinggaja.post.dto.EatingDetail;
import com.yesgaori.campinggaja.post.dto.EatingMainList;
import com.yesgaori.campinggaja.post.dto.ItemBestList;
import com.yesgaori.campinggaja.post.dto.ItemDetail;
import com.yesgaori.campinggaja.post.dto.ItemMainList;
import com.yesgaori.campinggaja.post.dto.PostDetail;
import com.yesgaori.campinggaja.post.dto.RecruitmentBestList;
import com.yesgaori.campinggaja.post.dto.RecruitmentDetail;
import com.yesgaori.campinggaja.post.dto.RecruitmentMainList;
import com.yesgaori.campinggaja.post.service.PostService;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	private PostService postService;

	@GetMapping("/main-view")
	public String timeLine(Model model) {
		
		List<CampingBestList> bestList1 = postService.campingBestList();
		List<CampingBestList> bestList2 = postService.eatingBestList();
		List<ItemBestList> bestList3 = postService.itemBestList();
		List<RecruitmentBestList> bestList4 = postService.BestParticipantsList();
		
		model.addAttribute("bestList1", bestList1);
		model.addAttribute("bestList2", bestList2);
		model.addAttribute("bestList3", bestList3);
		model.addAttribute("bestList4", bestList4);
		
		return "/post/main";
	}
	
	
	@GetMapping("/camping-diary/create-view")
	public String diaryCreateView() {
		
		return"/post/diaryInput";
	}
	
	@GetMapping("/main/diary-view")
	public String diaryMainView(Model model) {
			
		List<CampingMainList> diaryList = postService.selectDiary();
		List<CampingBestList> bestList = postService.campingBestList();
		
		model.addAttribute("diaryList", diaryList);
		model.addAttribute("bestList", bestList);
			
			return"/post/diaryMain";
	}
	
	@GetMapping("/camping-diary/detail-view")
	public String postDetail(@RequestParam("id") int id
							, @RequestParam("category")int category
							, Model model
							, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		PostDetail postList = postService.getPost(userId, id, category);
		
		model.addAttribute("postList", postList);
		
		return "post/diaryDetail";
	}
	
	
	
	@GetMapping("/eating-diary/create-view")
	public String eatingCreateView() {
		
		return"/post/eatingInput";
	}
	
	@GetMapping("/main/eating-view")
	public String eatingMainView(Model model) {
			
		List<EatingMainList> eatingList = postService.selectEatingList();
		List<CampingBestList> bestList = postService.eatingBestList();
		
		model.addAttribute("bestList", bestList);
		model.addAttribute("eatingList", eatingList);
			
			return"/post/eatingMain";
	}
	
	@GetMapping("/eating-diary/detail-view")
	public String eatingDetail(@RequestParam("id") int id
							, @RequestParam("category") int category
							, Model model
							, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		EatingDetail eatingList = postService.getEating(userId, id, category);
		
		model.addAttribute("eatingList", eatingList);
		
		return "post/eatingDetail";
	}
	
	@GetMapping("/item/create-view")
	public String itemCreateView() {
		
		return"/post/itemInput";
	}
	
	@GetMapping("/main/item-view")
	public String itemMainView(Model model) {
			
		List<ItemMainList> itemList = postService.selectItemList();
		List<ItemBestList> bestList = postService.itemBestList();
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("bestList", bestList);
			
			return"/post/itemMain";
	}
	
	@GetMapping("/item/detail-view")
	public String itemDetail(@RequestParam("id") int id
							, Model model
							, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		ItemDetail itemList = postService.getItem(userId, id);
		
		model.addAttribute("itemList", itemList);
		
		return "post/itemDetail";
	}
	
	@GetMapping("/recruitment/create-view")
	public String recruitmentCreateView() {
			
		return"/post/recruitmentInput";
	}
	
	@GetMapping("/main/recruitment-view")
	public String recruitmentMainView(Model model) {
			
		List<RecruitmentMainList> recruitmentList = postService.selectRecruitmentList();
		List<RecruitmentBestList> bestList = postService.BestParticipantsList();

		model.addAttribute("recruitmentList", recruitmentList);
		model.addAttribute("bestList", bestList);
		
			
			return"/post/recruitmentMain";
	}
	
	@GetMapping("/recruitment/detail-view")
	public String recruitmentDetail(@RequestParam("id") int id
							, Model model
							, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		RecruitmentDetail recruitmentList = postService.getRecruitment(userId, id);
		
		model.addAttribute("recruitmentList", recruitmentList);
		
		return "post/recruitmentDetail";
	}
	
	@GetMapping("/inquiry-view")
	public String inquiryView() {
		
		return "/post/inquiry";
	}
	
	
}
