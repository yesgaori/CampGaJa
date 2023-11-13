<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CampingGaJa alarm</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/mainHeader.jsp" />
		<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		<section>
			<c:forEach var="title" items="${titleList }">
				<table class="table text-center">
					<div id="recruitmentTitle${title.postId }">
						<h2>${title.title}<a class="text-success">${title.personnel}</a></h2>
					</div>
					<c:forEach var="post" items="${postList }">
						<thead>
							<tr>
								<th class="col-2">자기소개.</th>
								<th class="col-4">나이/성별/차량/장비</th>
								<th class="col-2">Kakao</th>
								<th class="col-2">Date</th>
								<th class="col-2">Send</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><i class="bi bi-card-text mr-2 mt-1 more-btn" style="font-size:2rem;" data-toggle="modal" data-target="#exampleModalCenter${post.participantsId }"></i></td>
								<td>${post.age }/${post.qualifications }</td>
								<td>${post.kakao }</td>
								<td>
									${post.appointmentStartDate } ~ 
									${post.appointmentEndDate }
								</td>
								<td>
									<button type="button" class="btn btn-success">승인</button>
									<button type="button" class="btn btn-danger reject-btn" data-participants-id="${post.participantsId }">반려</button>
								</td>
							</tr>
						</tbody>
										<!-- Modal -->
						<div class="modal fade" id="exampleModalCenter${post.participantsId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
						  <div class="modal-dialog modal-dialog-centered" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body d-flex justify-content-center">
								<div>${post.content }</div>
						      </div>
						      <div class="modal-footer">
						      </div>
						    </div>
						  </div>
						</div>
					</c:forEach>
				</c:forEach>
			</table>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />

	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
	$(document).ready(function(){
		
		$(".reject-btn").on("click", function() {
			
			let id = $(this).data("participants-id");
			
			
			$.ajax({
				type:"delete"
				, url:"/post/recruitment/participation/reject"
				, data:{"participantsId":id}
				, success:function(data) {
					if(data.result == "success") {
						location.reload();
					} else {
						alert("삭제 실패");
					}
				}
				, error:function() {
					alert("삭제 에러");
				}
			});
			
		});

	});
	

	
	
	</script>
	
</body>
</html>