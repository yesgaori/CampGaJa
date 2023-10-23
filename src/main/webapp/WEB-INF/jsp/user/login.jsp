<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CampingGaJa</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div class="wrap">
		<c:import url="/WEB-INF/jsp/include/loginHeader.jsp" />
		<section class="login d-flex justify-content-center align-items-center">
			<div>
				<div class="text-center">
					<h3 class="mb-3">함께하면 더 즐거운,</h3>
					<h5 class="mb-5 text-center">캠핑 가자 !</h5>
				</div>
				<div class="pt-5">
					<input type="text" placeholder="아이디" class="form-control mb-2"><br>
					<input type="password" placeholder="비밀번호" class="form-control mb-5"><br>
					<div class="d-flex justify-content-center mb-3">
						<button type="button" class="btn btn-primary w-75">Login</button>
					</div>
					<div class="d-flex justify-content-center">
						<a href="/user/join-view">방문이 처음이신가요? 회원이 돼보세요</a>
					</div>
				</div>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	
	
	</div>
	
	
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			
			
			
			
			
		});
	</script>	
	
</body>
</html>