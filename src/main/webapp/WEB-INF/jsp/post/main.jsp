<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CampingGaJa Main</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
	<div id="wrap">
		<header class="d-flex">
			<div class="mainHead"></div>
			<div class="mainHead">
				<c:import url="/WEB-INF/jsp/include/mainHeader.jsp" />
			</div>
			<div class="d-flex align-items-center justify-content-end mainHead">
				<c:if test="${not empty userId }">
					<div class="mr-3">${userLoginId }님 <a href="/user/logout">로그아웃</a></div>
				</c:if>
				<i class="bi bi-chat-dots mr-2"></i>
				<i class="bi bi-gear"></i>
			</div>
		</header>
		<hr>
		<nav>
			<ul class="list-group">
				<div class="d-flex text-center">
					<a href="#" class="list-group-item list-group-item-action">캠핑후기</a>
					<a href="#" class="list-group-item list-group-item-action">캠핑 먹부림</a>
					<a href="#" class="list-group-item list-group-item-action">장비추천</a>
					<a href="#" class="list-group-item list-group-item-action">캠퍼모집</a>
				</div>
			</ul>
		</nav>
		<section>
			<div id="section1">
				<h2 class="pt-2 pl-2">인기 캠핌후기</h2>	
			</div>
			<div id="section2">
				<h2 class="pt-2 pl-2">인기 캠핑 먹부림</h2>
			</div>
			<div id="section3">
				<h2 class="pt-2 pl-2">인기 장비추천</h2>
			</div>
			<div id="section4">
				<h2 class="pt-2 pl-2">인기 캠퍼모집</h2>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
	
	
	</script>
	
</body>
</html>