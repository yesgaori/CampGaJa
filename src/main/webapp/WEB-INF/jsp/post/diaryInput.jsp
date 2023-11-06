<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Camping GaJa - 캠핑후기 작성</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<!-- services 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=be500f79d6dd785c2fe5471580292453&libraries=services"></script>

</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/mainHeader.jsp" />
		<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		<section>
			<div class="d-flex mb-3 mt-5">
				<h3>제목 : </h3>
				<input type="text" class="w-75 ml-3" id="titleInput">
			</div>
			<div>
				<textarea id="summernote" class="contentInput"></textarea>
			</div>
		 	<form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="캠핑장" id="keyword" size="15"> 
                    <button type="submit">검색하기</button> 
            </form>
			<div id="map" style="width:100%;height:350px;"></div>
			<div class="d-flex justify-content-center">
				<button id="addBtn" type="button" class="btn btn-primary mt-5" data-imagePath="${fileUpload.url }">게시하기</button>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>	
	
	var mapPath;
	
	// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
	var infowindow = new kakao.maps.InfoWindow({zIndex:1});

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 장소 검색 객체를 생성합니다
	var ps = new kakao.maps.services.Places(); 
	

	function searchPlaces() {

	    var keyword = document.getElementById('keyword').value;

	    if (!keyword.replace(/^\s+|\s+$/g, '')) {
	        alert('키워드를 입력해주세요!');
	        return false;
	    }

	    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
	    ps.keywordSearch( keyword, placesSearchCB); 
	}	

	 

	// 키워드 검색 완료 시 호출되는 콜백함수 입니다
	function placesSearchCB (data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {

	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
	        // LatLngBounds 객체에 좌표를 추가합니다
	        var bounds = new kakao.maps.LatLngBounds();

	        for (var i=0; i<data.length; i++) {
	            displayMarker(data[i]);    
	            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
	        }       

	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	        map.setBounds(bounds);
	    } 
	}

	// 지도에 마커를 표시하는 함수입니다
	function displayMarker(place) {
	    
	    // 마커를 생성하고 지도에 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: new kakao.maps.LatLng(place.y, place.x) 
	    });

	    // 마커에 클릭이벤트를 등록합니다
	    kakao.maps.event.addListener(marker, 'click', function(mouseEvent) {
	        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
	        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
	        infowindow.open(map, marker);
           	
	        mapPath = place.road_address_name;

            
	    });
	  
	}
	
	$(document).ready(function () {
		
		$('#summernote').summernote({
	        placeholder: 'Hello stand alone ui',
	        tabsize: 2,
	        height: 400,
	        toolbar: [
	          ['style', ['style']],
	          ['font', ['bold', 'underline', 'clear']],
	          ['color', ['color']],
	          ['para', ['ul', 'ol', 'paragraph']],
	          ['table', ['table']],
	          ['insert', ['link', 'picture', 'video']],
	          ['view', ['fullscreen', 'codeview', 'help']]
	        ],
	        callbacks: {
	            onImageUpload : function(files){
	            	
	            	uploadSummernoteImageFile(files[0],this);
	            	
	            }	
	            	
	         }
	            
		
		
		
      	});
		

        function uploadSummernoteImageFile(file,editor){ 


            data = new FormData(); 


            data.append("imagePath",file); 


            $.ajax({ 
	         data:data, 
	         type:"POST", 
	         url:"/post/image-upload",  
	         contentType:false, 
	         processData:false, 
	         success:function(data){ 
				if(data.url != null){
					$(editor).summernote("insertImage",data.url); 
				} else{
					alert("이미지 저장 실패");
				};
				
	         },
	         error:function(){
	        	 alert("이미지 저장 오류");
	         }
	
	     }); 


        } 
		
		$("#addBtn").on("click", function() {
			
			let title = $("#titleInput").val();
			let content = $(".contentInput").val();
			let imagePath = $(this).data("imagePath");
			
			
			if(title == "") {
				alert("제목을 입력하세요");
				return ;
			}
			
			if(content == "") {
				alert("내용을 입력하세요");
				return ;
			}
			
			if(mapPath == "") {
				alert("장소를 선택하세요");
				return ;
			}
				
			
			$.ajax({
				type:"post"
				, url:"/post/camping-diary/create"
				, data:{"title":title, "content":content, "imagePath":imagePath, "mapPath":mapPath}
				, success:function(data) {
					if(data.result == "success") {
						location.href = "/post/main/diary-view";
					} else {
						alert("글쓰기 실패");
					}
					
				}
				, error:function() {
					alert("글쓰기 에러");
				}
			});
			
		});
		
		
		
		
    });
	
	</script>
</body>
</html>