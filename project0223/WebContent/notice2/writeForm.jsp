<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>

  <!-- Bootstrap 라이브러리 등록 - CDN방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<!-- formUtil.js 등록 -->
<script type="text/javascript" src="../js/formUtil.js"></script>

<script type="text/javascript">

$(function(){
	$("#cancleBtn").click(function(){
	history.back();
	});
	
	// submit()이 이벤트에 데이터 검사
	$("#writeForm").submit(function(){
		
		// 필수 입력
		// 제목
		if(!require($("#title"), "제목")) return false;
		if(!checkLength($("#title"), "제목", 4)) return false;
		// 내용
		if(!require($("#content"), "내용")) return false;
		if(!checkLength($("#content"), "내용", 4)) return false;
		// 작성자
		if(!require($("#startDate"), "공지 시작일")) return false;
		if(!checkLength($("#startDate"), "공지 시작일", 10)) return false;
		
		if(!require($("#endDate"), "공지 종료일")) return false;
		if(!checkLength($("#endDate"), "공지 종료일", 10)) return false;
		
	});
});

</script>


</head>
<body>
<div class="container">

	<h1>공지사항 글쓰기</h1>

	<form action="write.jsp" method="post" id="writeForm">
		<div class="form-group">
			<!-- 제목 -->
			<label for="title">제목</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="title" class="form-control" id="title" required="required"
			 placeholder="제목 입력 - 3글자 이상 100자 이내">
		</div>
		
		<div class="form-group">
			<!-- 내용 -->
			<label for="content">내용</label>
			<textarea rows="7" name="content" class="form-control" id="content"
			 ></textarea>
		</div>
		
		<div class="form-group">
			<!-- 작성자 -->
			<label for="startDate" >공지 시작일</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="startDate" class="form-control" id="startDate" type="date">
		</div>
		
		<div class="form-group">
			<!-- 작성자 -->
			<label for="endDate" >공지 종료일</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="endDate" class="form-control" id="endDate" type="date">
		</div>
		
		<!-- 데이터를 전송하는 type="submit" 버튼 - 버튼의 기본이므로 생략 가능한다. -->
		<button class="btn btn-default">등록</button>
		<!-- 데이터를 새로 입력하는 type = "reset" 버튼 -->
		<button type="reset" class="btn btn-default">새로입력</button>
		<!-- 취소하려면 버튼모양으로 사용(type="button")하고 취소의 동작을 JS로 작성한다.
			history.back() : 이전 페이지로 이동 -->
		<button type="button" onclick="history.back()" class="btn btn-default">취소</button>
	</form>
	
</div>
</body>
</html>