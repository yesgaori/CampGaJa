<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="d-flex">
	<div class="mainHead"></div>
	<div class="mainHead">
	<div class="d-flex justify-content-center align-items-center mt-4">
		<img src="/static/images/camp-1849133_1280.png" width="50px" height="50px">
		<h1 class="display-5">CampingGaJa</h1>
	</div>
	</div>
		<div class="d-flex align-items-center justify-content-end mainHead">
			<c:if test="${not empty userId }">
				<div class="mr-3">${userLoginId }님 <a href="/user/logout">로그아웃</a></div>
			</c:if>
		<i class="bi bi-chat-dots mr-2"></i>
		<i class="bi bi-gear"></i>
	</div>
</header>