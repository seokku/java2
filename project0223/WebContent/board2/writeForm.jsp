<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>

  <!-- 부트스트랩 라이브러리 등록 - CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<!-- formUtil.js 등록 --> 
<script type="text/javascript" src="../js/formUtil.js">
$(function(){
	// 이벤트 처리
	// 최소 버튼 - 이전 페이지(리스트)로 돌아간다.
	$("#cancelBtn").click(function(){
	// alert("취소");
	// 이전 페이지로 이동
	history.back();
	});
	
	// submit() 이벤트에 데이터 검사
	$("#writeForm").submit(function(){
		// alert("데이터 전달 이벤트");
		
		// 필수 입력
		// 제목
		// alert(!require($("#title"), "제목"));
		if(!require($("#title"), "제목")) return false;
		// 내용
		if(!require($("#content"), "내용")) return false;
		// 작성자
		if(!require($("#writer"), "작성자")) return false;
		
		// 길이
		// 제목 3자이상
		if(!checkLength($("#title"), "제목", 3)) return false;
		// 내용 4자이상
		if(!checkLength($("#content"), "내용", 4)) return false;
		// 작성자 2자 이상
		if(!checkLength($("#writer"), "작성자", 2)) return false;
		
		// submit 이벤트 취소
		// return false; 
	});
});

</script> 
  
  
<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}

</style>

</head>
<body>
<div class="container">
<h1>게시판 글쓰기</h1>
		<form action="write.jsp" method="post" id="writeForm">
		<div class="form-group"> 
			<!-- 제목 -->
			<label for="title">제목</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="title" class="form-control" id="title" required="required"
			 placeholder="제목은 4자이상 입력하셔야 합니다.">
		</div>
		
		<div class="form-group">
			<!-- 내용 -->
			<label for="content">내용</label>
			<textarea rows="5" name="content" class="form-control" id="content" required="required"
			  placeholder="내용은 4자이상 입력하셔야 합니다."></textarea>
		</div>
		
		<div class="form-group">
			<!-- 작성자 -->
			<label for="writer" >작성자</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="writer" class="form-control" id="writer" required="required"
			placeholder="작성자는 2자이상 입력하셔야 합니다.">
		</div>
		
		<button class="btn btn-default">등록</button>
		<!-- 데이터를 새로 입력하는 type = "reset" 버튼 -->
		<button type="reset" class="btn btn-default">새로입력</button>
		<!-- 취소하려면 버튼모양으로 사용(type="button")하고 취소의 동작을 JS로 작성한다.
			history.back() : 이전 페이지로 이동 -->
		<button type="button" class="btn btn-default" id="cancelBtn">취소</button>
		</form>
</div>




</body>
</html>