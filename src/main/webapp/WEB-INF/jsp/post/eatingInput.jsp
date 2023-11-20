<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Camping GaJa - 캠핑 먹부림 작성</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/mainHeader.jsp" />
		<c:import url="/WEB-INF/jsp/include/nav.jsp" />
		<section>
			<div class="d-flex mb-3 mt-5">
				<h3>제목 : </h3>
				<input type="text" class="form-control w-75 ml-3" id="titleInput">
			</div>
			<div>
				<textarea id="summernote" class="contentInput"></textarea>
			</div>
			<div class="d-flex justify-content-center">
				<button id="addBtn" type="button" class="btn btn-primary mt-5">게시하기</button>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
	
		var thumbnailPath;
		
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
						if(thumbnailPath == null){
							thumbnailPath = data.url;
						}
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

				
				
				if(title == "") {
					alert("제목을 입력하세요");
					return ;
				}
				
				if(content == "") {
					alert("내용을 입력하세요");
					return ;
				}
				
					
				
				$.ajax({
					type:"post"
					, url:"/post/eating-diary/create"
					, data:{"title":title, "content":content, "thumbnailPath":thumbnailPath}
					, success:function(data) {
						if(data.result == "success") {
							location.href = "/post/main/eating-view";
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