<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑 먹부림</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/mainHeader.jsp" />
		<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		<section>
			<div id="section2">
				<h2 class="pt-2 pl-2">인기 캠핑 먹부림</h2>	
			</div>
			<div class="d-flex">
				<table class="table text-center">
					<thead>
						<tr>
							<th class="col-2">No.</th>
							<th class="col-6">Title</th>
							<th class="col-2">Name</th>
							<th class="col-2">Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="post" items="${eatingList }">
						<tr>
							<td>${post.postId }</td>
							<td><a href="/post/eating-diary/detail-view?id=${post.postId }&category=2" >${post.title }</a></td>
							<td>${post.userName }</td>
							<td><fmt:formatDate value="${post.createdAt }" pattern="yyyy-MM-dd" /></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="d-flex justify-content-end">
				<a class="btn btn-primary" href="/post/eating-diary/create-view">글쓰기</a>
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