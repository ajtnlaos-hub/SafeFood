<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap 3.3.7이하는 jQuery 1.x, 3.3.7이상으로 업그레이드 필요 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- jQuery 추가 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/top.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form method="post" action="findPassword.do">
					<h2>
						<strong>아이디를 입력하세요.</strong>
					</h2>
					<br><label for="id"><b>아이디 *</b></label> 
					<input type="text" name="id" id="id" class="form-control" placeholder="ID" required autofocus=""><br>
					<br><label for="name"><b>이름 *</b></label> 
					<input type="text" name="name" id="name" class="form-control" placeholder="Name" required autofocus=""><br>
					<button type="submit" class="btn btn-primary">비밀번호 찾기</button>
				</form>
			</div>
		</div>
	</div>	
	<jsp:include page="/bottom.jsp"></jsp:include>
</body>
</html>