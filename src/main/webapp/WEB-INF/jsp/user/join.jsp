<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div class="wrap">
		<c:import url="/WEB-INF/jsp/include/loginHeader.jsp" />
		<section class="join d-flex justify-content-center align-items-center">
			<div class="text-center">
				<div>
					<div class="d-flex align-items-center  mb-4">
						<input type="text" id="idInput" placeholder="로그인 아이디" class="form-control mr-2">
						<button type="button" class="btn">중복확인</button><br>
					</div>
					<div>
						<input type="password" id="passwordInput" placeholder="비밀번호" class="form-control mb-1"><br>
						<input type="password" id="passwordConfirmInput" placeholder="비밀번호 확인" class="form-control mb-1"><br>
					</div>
					<div class="d-flex align-items-center mb-4">
						<input type="text" id="nicknameInput" placeholder="닉네임" class="form-control mr-2">
						<button type="button" class="btn btn-secandary">중복확인</button><br>
					</div>
					<div>
						<input type="text" id="emailInput" placeholder="name@example.com" class="form-control mb-3">
					</div>
					<div>
						<button type="button" class="btn btn-primary mb-3">가입하기</button>
					</div>
					<a href="/user/login-view">이미 회원이신가요 ?</a>
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