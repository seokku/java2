<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게 시 판3 글 쓰 기</title>
  <!-- CDN 방식 부트스트랩 라이브러리 등록 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../js/formUtil.js"></script>
<script type="text/javascript">
$(function(){
	// 이벤트 처리
	// 데이터 전송시 데이터의 유효성 검사 처리 이벤트
	$("#writeForm").submit(function(){
		// 비어있는 항목 검사
		if(!require($("#title"), "제목")) return false;
		if(!require($("#content"), "내용")) return false;
		if(!require($("#writer"), "작성자")) return false;
		// 데이터 길이 검사
		if(!checkLength($("#title"), "제목", 4)) return false;
		if(!checkLength($("#content"), "내용", 4)) return false;
		if(!checkLength($("#writer"), "작성자", 2)) return false;
	});
	// 취소버튼
	$("#cancelBtn").click(function(){
		history.back();
	});
});
</script>

</head>

<body>
<div class="container">
<h1>게 시 판3 글 쓰 기 </h1>
	<form action="write.jsp" method="post" id="writeForm">
		<div class="form-group">
			<!-- 제목 -->
			<label for="title">제목</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="title" class="form-control" id="title" required="required"
			 placeholder="제목 입력 - 4글자 이상 100자 이내">
		</div>
		
		<div class="form-group">
			<!-- 내용 -->
			<label for="content">내용</label>
			<textarea rows="7" name="content" class="form-control" id="content"
			 required="required" placeholder="내용 입력 - 4글자 이상 100자 이내"></textarea>
		</div>
		
		<div class="form-group">
			<!-- 작성자 -->
			<label for="writer" >작성자</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="writer" class="form-control" id="writer" 
			placeholder="작성자 입력 " required="required">
		</div>
				<button class="btn btn-default">글작성</button>
				<button type="reset" class="btn btn-default">새로 입력</button>
				<button type="button" id="cancelBtn" class="btn btn-default">취소</button>
	</form>
</div>
</body>
</html>