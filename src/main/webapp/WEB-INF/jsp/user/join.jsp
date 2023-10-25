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
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/loginHeader.jsp" />
		<section class="join d-flex justify-content-center align-items-center">
			<div class="text-center">
				<div>
					<div class="d-flex align-items-center  mb-4">
						<input type="text" id="idInput" placeholder="로그인 아이디" class="form-control mr-2">
						<button type="button" class="btn" id="duplicateId">중복확인</button><br>
					</div>
					<h5 class="small d-none text-danger duplicateId">이미 사용중인 아이디 입니다</h5>
					<h5 class="small d-none text-success avaliableId">사용가능한 아이디 입니다</h5>
					<div>
						<input type="password" id="passwordInput" placeholder="비밀번호" class="form-control mb-1"><br>
						<input type="password" id="passwordConfirmInput" placeholder="비밀번호 확인" class="form-control mb-1"><br>
					</div>
					<div class="d-flex align-items-center mb-4">
						<input type="text" id="nickNameInput" placeholder="닉네임" class="form-control mr-2">
						<button type="button" class="btn btn-secandary" id="duplicateName">중복확인</button><br>
					</div>
					<h5 class="small d-none text-danger duplicateName">이미 사용중인 아이디 입니다</h5>
					<h5 class="small d-none text-success avaliableName">사용가능한 아이디 입니다</h5>
					<div>
						<input type="text" id="emailInput" placeholder="name@example.com" class="form-control mb-3">
					</div>
					<div>
						<button type="button" class="btn btn-primary mb-3" id="joinBtn">가입하기</button>
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
			
			var isCheckDuplicate = false;
			var isDuplicate = true;
			var isCheckDuplicate2 = false;
			var isDuplicate2 = true;
			
			$("#idInput").keyup(function (e) {
				let content = $(this).val();
			    // 글자수 제한
			    if (content.length > 15) {
			    	// 16자 부터는 타이핑 되지 않도록
			        $(this).val($(this).val().substring(0, 15));
			        // 16자 넘으면 알림창 뜨도록
			        alert("글자수는 15자까지 입력 가능합니다.");
			    };
			});
			
			$("#nickNameInput").on("click", function() {
				isCheckDuplicate2 = false;
				isDuplicate2 = true;
				$(".avaliableName").addClass("d-none");
				$(".duplicateName").addClass("d-none");
			});
			
			$("#idInput").on("click", function() {
				isCheckDuplicate = false;
				isDuplicate = true;
				$(".avaliableId").addClass("d-none");
				$(".duplicateId").addClass("d-none");
			});
			
			$("#duplicateName").on("click", function() {
						
				let loginName = $("#nickNameInput").val();
				
				if(loginName == "") {
					alert("닉네임을 입력하세요");
					return;
				}
				
				
				$.ajax({
					type:"get"
					, url:"/user/join/confirm-name"
					, data:{"name":name}
					, success:function(data){
						isCheckDuplicate2 = true;
						if(data.isDuplicate == true) {
							// 중복 되었다
							$(".duplicateName").removeClass("d-none");
							$(".avaliableName").addClass("d-none");
							isDuplicate2 = true;
						} else {
							// 중복 되지 않았다
							$(".duplicateName").addClass("d-none");
							$(".avaliableName").removeClass("d-none");
							isDuplicate2 = false;
						}
					}
					,error:function(){
						alert("중복 닉네임 확인 에러")
					}
				});
				
			});
			
			$("#duplicateId").on("click", function() {
				let content = $("#idInput").val();
				
				let loginId = $("#idInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력하세요");
					return;
				}
				
				if(content.length < 6){
					alert("아이디는 최소 5자 이상입니다");
					return;
				};
				
				if(content.length > 15){
					alert("아이디는 최소 5자 이상입니다");
					return;
				};
				
				$.ajax({
					type:"get"
					, url:"/user/join/confirm-id"
					, data:{"loginId":loginId}
					, success:function(data){
						isCheckDuplicate = true;
						if(data.isDuplicate == true) {
							// 중복 되었다
							$(".duplicateId").removeClass("d-none");
							$(".avaliableId").addClass("d-none");
							isDuplicate = true;
						} else {
							// 중복 되지 않았다
							$(".duplicateId").addClass("d-none");
							$(".avaliableId").removeClass("d-none");
							isDuplicate = false;
						}
					}
					,error:function(){
						alert("중복 아이디 확인 에러")
					}
				});
				
			});
			$("#joinBtn").on("click", function() {
				let loginId = $("#idInput").val();
				let password = $("#passwordInput").val();
				let passwordConfirm = $("#passwordConfirmInput").val();
				let name = $("#nickNameInput").val();
				let email = $("#emailInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력하세요");
					return;
				} 
				
				// 중복체크가 안된경우
				if(!isCheckDuplicate) {
					alert("아이디 중복 체크를 해주세요")
					return;
				}
				
				if(!isCheckDuplicate2) {
					alert("닉네임 중복 체크를 해주세요")
					return;
				}
				
				// 중복된 아이디인 경우
				if(isDuplicate) {
					alert("중복된 아이디 입니다.")
					return;
				}
				
				if(isDuplicate2) {
					alert("중복된 닉네임 입니다.")
					return;
				}
				
				if(password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}
				
				if(password != passwordConfirm) {
					alert("비밀번호가 일치하지 않습니다")
					return;
				}
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				if(email == "") {
					alert("이메일을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/user/join"
					, data:{"loginId":loginId,"password":password,"name":name,"email":email}
					, success:function(data) {
						if(data.result == "success"){
							location.href = "/user/login-view";	
							
						} else {
							alert("회원가입 실패 !!")
						}
						
					}
					, error:function() {
						alert("회원가입 에러!!");
					}
				});
			});
			
			
			
		});
	</script>
</body>
</html>