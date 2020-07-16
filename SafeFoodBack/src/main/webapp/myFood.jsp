<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품정보</title>
<!-- bootstrap 3.3.7이하는 jQuery 1.x, 3.3.7이상으로 업그레이드 필요 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- jQuery 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
.jumbotron {
	height: 400px;
	background: white;
	background-image:
		url('https://images.unsplash.com/photo-1543352634-a1c51d9f1fa7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	padding-top: 120px;
	margin-top: 10px;
}

#search {
	background: gray !important;
	color: white !important;
	padding: 20px 10px;
}

.container {
	margin-bottom: 10px;
}

@import url('https://fonts.googleapis.com/css?family=Jua&display=swap');

#title {
	font-family: 'Jua', sans-serif;
}

#navbar {
	padding-right: 20px;
}

footer {
	background: #f0f0f0;
	padding: 5px 15px 10px 15px;
}

#itemTxt {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	height: 20px;
}
</style>
</head>
<body>
	<jsp:include page="/top.jsp" />
	<div class="container">
		<h2 class="text-center">내 섭취 목록</h2>
		<br> <br>
		<div id="getList" class="container-fluid">

			<c:forEach items="${myFood }" var="historyDetail">
				<div id="row">
					<div id="img" class="col-md-3">
						<img alt="" src="${historyDetail.img }" width="50%">
					</div>
					<div id="content" class="col-md-9">
						<div id="historyName"><h4><strong>${historyDetail.name }</strong></h4></div>
						<div id="historyCount">${historyDetail.count }</div>
						<div id="historyeatingDate">${historyDetail.eatingDate }</div>
						<p>
							<a class="btn btn-info" href="detail.do?code=${historyDetail.code}" role="submit" onclick="">Viewdetails</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>


	</div>
	<jsp:include page="/bottom.jsp" />
</body>
</html>