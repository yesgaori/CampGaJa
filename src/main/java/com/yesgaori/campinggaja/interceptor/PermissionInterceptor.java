package com.yesgaori.campinggaja.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class PermissionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(
					HttpServletRequest request
					, HttpServletResponse response
					, Object handler) throws IOException {
		
		// 로그인 안된 상태에서 메모 게시글 관련 페이지 접근을 막고
		// 로그인 페이지로 이동
		HttpSession session = request.getSession();
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		// /user/login-view
		String uri = request.getRequestURI();
		
		// 로그인이 안된 경우 /post 로 시작하는 주소로 접근하는 경우 페이지 이동을 막고 로그인 페이지로 이동한다.
		if(userId == null) {
			if(uri.startsWith("/post")) {
				
					response.sendRedirect("/user/join-view");
				
				return false;
			}
			
		} else { //로그인이 돼있는 경우 / user로 시작하는 주소로 접근하는 경우 페이지 이동을 막고 리스트 페이지로 이동
			if(uri.startsWith("/user")) {
				
				response.sendRedirect("/post/main-view");
				
				return false;
			}
		}
		
		return true;
	}
	
	
}
