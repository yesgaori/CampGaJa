<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${eatingList.title }</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<!-- services 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=be500f79d6dd785c2fe5471580292453&libraries=services"></script>
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/mainHeader.jsp" />
		<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		<section>
		<hr>
		<div class="d-flex justify-content-between">
			<div>
				<h2>${eatingList.title }</h2>
				<div class="d-flex">
					<h4><i class="bi bi-person-fill">${eatingList.name }</i></h4>
					<h4><i class="bi bi-heart-fill ml-5">${eatingList.likeCount }</i></h4>
				</div>
				<div>${eatingList.createdAt }</div>
			</div>
			<div class="mr-3 mt-3">
				<%-- 로그인 한 사용자의 게시글에만 more-btn 노출 --%>
				<c:if test="${eatingList.userId eq userId }">
				<i class="bi bi-gear mr-2 mt-1 more-btn" style="font-size:2rem;" data-toggle="modal" data-post-id="${postList.id }") data-target="#exampleModalCenter"></i>
				</c:if>
			</div>
		</div>
		<hr>
		<div>
			<h4>${eatingList.content }</h4>
			<hr class="mt-5 mb-5">
		</div>
		<div class="d-flex justify-content-center align-items-center">
			<div>
			<div class="ml-3">
				<c:choose>
					<c:when test="${eatingList.like }">
						<i class="bi bi-heart-fill unlike-icon " style="font-size:5rem; color: red; cursor: pointer;" data-post-id="${eatingList.id }"></i>
					</c:when>
					<c:otherwise>
						<i class="bi bi-heart like-icon" style="font-size:5rem; cursor: pointer;" data-post-id="${eatingList.id }"></i>
					</c:otherwise>
				</c:choose>
			</div>
			<h4>좋아요 ${eatingList.likeCount }개</h4>
			</div>
		</div>	
		<div class="mt-5 justify-content-center">
			<c:forEach var="comment" items="${eatingList.commentList }">
				<hr>
				<div class="d-flex">							
					<i class="bi bi-person-square"></i>
					<div class="d-flex">
						<h5>${comment.loginId }</h5>
						<div class="ml-3">${comment.content }</div>
					</div>
				</div>
				<hr>
			</c:forEach>
			<div class="d-flex align-items-center justify-content-center contain">
				<input type="text" class="col-10 form-control" id="commentInput${eatingList.id }"></input>
				<button type="button" class="btn btn-primary comment-btn" data-post-id="${eatingList.id }" data-category="2">게시</button>
			</div>
		</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body d-flex justify-content-center">
			      <button type="button" class="btn btn-primary modifyBtn">수정하기</button>
			      <button type="button" class="btn btn-danger deleteBtn ml-3">삭제하기</button>
		      </div>
		      <div class="modal-footer">
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		
		
		$(document).ready(function() {
			
			$(".unlike-icon").on("click", function() {
				let postId = $(this).data("post-id")
				
				$.ajax({
					type:"delete"
					, url:"/post/unlike"
					, data:{"postId":postId, "category":2}
					,success:function(data) {
						
						if(data.result == "success"){
							location.reload();
						} else{
							alert("좋아요버튼 실패")
						}
						
					}
					,error:function() {
						alert("좋아요버튼 에러")
					}
					
					
				});
				
			});
			
			$(".like-icon").on("click", function() {
				
				let postId = $(this).data("post-id");
				
				$.ajax({
					type:"post"
					, url:"/post/like"
					, data:{"postId":postId, "category":2}
					, success:function(data) {
						
						if(data.result == "success") {
							location.reload();
						} else {
							alert("좋아요 실패");
						}
						
					}
					, error:function() {
						alert("좋아요 에러");
					}
				});
				
				
			});
			
			$(".comment-btn").on("click", function() {
				
				
				let postId = $(this).data("post-id");
				let category = $(this).data("category");
				let comment = $("#commentInput" + postId).val();
				
				$.ajax({
					type:"post"
					, url:"/post/comment/create"
					, data:{"postId":postId, "content":comment, "category":category}
					, success:function(data) {
						
						if(data.result == "success") {

							location.reload();
							
						}else {
							alert("댓글 작성 실패")
						}
						
					}
					,error:function() {
						alert("댓글 작성 에러")
					}
				});
				
				
			});
			
		});
	
	</script>
	
</body>
</html>