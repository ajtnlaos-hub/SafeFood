<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
				<form class="form-signin" action="login.do" method="post">
					<div class="modal-body">
						<h2 class="form-signin-heading">Log in</h2>
						<label for="id" class="sr-only">아이디</label> 
						<input type="text" name="id" id="id" class="form-control" placeholder="아이디"> 
						<label for="pw" class="sr-only">비밀번호</label>
						<input type="password" name="pw" id="pw" class="form-control" placeholder="비밀번호">
					</div>
					<div class="modal-footer">
						<input type="submit" value="login">
					</div>
				</form>
			</div>
			</div>
		</div>
	</div>
	<nav class="navbar">
		<div class="container">
			<div id="navbar" class="navbar-collapse collapse navbar-inverse" aria-expanded="false" style="height: 1px;">
				<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${empty loginUser}">
						<li id="findPassword"><button type="button" id="findPasswordBtn" class="btn btn-link">비밀번호 찾기</button></li>
						<li id="Loginout"><button type="button" class="btn btn-link" data-toggle="modal" data-target="#myModal">Log in</button></li>
						<li id="sign"><button type="button" id="signUpBtn" class="btn btn-link">sign up</button></li>
					</c:when>
					<c:otherwise>
						<li id="Loginout">
						<button type="button" class="btn btn-link" id="logoutBtn">Log out</button></li>
						<li id="sign"><button type="button" id="modifyBtn" class="btn btn-link">회원정보 수정</button></li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>
		
		<div class="container">
			<div class="navbar-header">
				<img alt="ssafy" id="ssafyImg" src="http://edu.ssafy.com/asset/images/header-logo.jpg">
			</div>
			<div id="navbar" class="navbar-collapse collapse"
				aria-expanded="false" style="height: 1px;">
				<ul class="nav navbar-nav">
					<li class="active"><a href="notice.do">공지사항</a></li>
					<li><a href="foodList.do">상품 정보</a></li>
					<li><a href="#">베스트 섭취 정보</a></li>
					<li><a href="#">내 섭취 정보</a></li>
					<li><a href="#">예상 섭취 정보</a></li>
					<li><a href="QnA.html">Q & A</a></li>
				</ul>
				<form class="navbar-form navbar-right" action="search.do" method="post">
					<input type="text" name="word" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>
<script>
<c:if test="${!empty message }">	
	alert("${message}");
	<c:remove var="message"/>
</c:if>
$("#logoutBtn").on("click", function() {
	location.href="logout.do";
})
$("#modifyBtn").on("click", function() {
	location.href="modify.do";
})
$("#signUpBtn").on("click", function() {
	location.href="signup.do";
});
$("#findPasswordBtn").on("click", function() {
	location.href="findPassword.do";
});
$("#ssafyImg").on("click", function() {
	location.href="main.do";
});
</script>











