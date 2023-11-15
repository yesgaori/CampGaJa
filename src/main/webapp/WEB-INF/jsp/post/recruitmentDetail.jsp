<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${itemList.title }</title>
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
				<h2>${recruitmentList.title }</h2>
				<div class="d-flex">
					<h4><i class="bi bi-person-fill">${recruitmentList.name }</i></h4>
					<h4><i class="bi bi-stars ml-5">${recruitmentList.personnelCount} / ${recruitmentList.personnel }</i></h4>
				</div>
				<div>${recruitmentList.createdAt }</div>
			</div>
			<div class="mr-3 mt-3">
				<%-- 로그인 한 사용자의 게시글에만 more-btn 노출 --%>
				<c:if test="${recruitmentList.userId eq userId }">
				<i class="bi bi-gear mr-2 mt-1 more-btn" style="font-size:2rem;" data-toggle="modal" data-post-id="${recruitmentList.id }") data-target="#exampleModalCenter"></i>
				</c:if>
			</div>
		</div>
		<hr>
		<div>
			<h4>${recruitmentList.content }</h4>
			<hr class="mt-5 mb-5">
			<h4 class="mb-3">캠핌장 위치</h4>
			<div id="map" style="width:100%;height:350px;" data-address="${recruitmentList.mapPath }"></div>
		</div>
		<div class="d-flex justify-content-center align-items-center">
			<div>
			<div class="ml-3">

			</div>
			<div class="d-flex justify-content-center align-items-center">
				<div>
					<h4>모집 완료인원</h4>
					<div class="d-flex justify-content-center align-items-center">
						<h1 class="text-success text-center">${recruitmentList.personnelCount}</h1><h5>/ ${recruitmentList.personnel }</h5>
					</div>
				</div>
			</div>
			<h4>신청개수 ${recruitmentList.participantsCount }개</h4>
			</div>
		</div>	
		<div class="mt-5 justify-content-center">
			<c:choose>
				<c:when test="${recruitmentList.confirm}">
					<h3 class="text-center">신청한 모집입니다.</h3>	
				</c:when>
				<c:when test="${recruitmentList.loginId == recruitmentList.userId}">
					<h3 class="text-center">내가 작성한 모집</h3>	
				</c:when>
				<c:otherwise>
					<div class="d-flex align-items-center justify-content-center contain">	
						<a href="/post/recruitment/participants-view?postId=${recruitmentList.id }" class="btn btn-primary">참여신청</a>
					</div>
				</c:otherwise>
			</c:choose>
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
		
		var mapAddress = $("#map").data("address")
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  
	
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(mapAddress, function(result, status) {
		
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">' + '캠핑장 위치' + '</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
		    } 
		
		$(document).ready(function() {
			
			
			
		});
	
	</script>
</body>
</html>