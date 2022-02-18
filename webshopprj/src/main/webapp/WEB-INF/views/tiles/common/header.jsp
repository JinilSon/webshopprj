<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="header">			<!-- header 부분 -->
	<div class="header-content">
		<div class="header-left">
			<h1><a href="/main">Webshopprj</a></h1>
		</div>
		<form action="/login" class="submit_form" method="GET">
		<input class="header-left-search" type="text" value="" placeholder=" 검색" size="20" maxlength="20" />
		<div class="user-button-div">
			
			<sec:authorize access="isAnonymous()">
				<h5 class="user-buttons"><a href="javascript:void(0)" class="submit_btn" onclick="take_action(this)">로그인</a></h5>
				<h5 class="user-buttons"><a>회원가입</a></h5>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<h5 class="user-buttons"><a href="javascript:void(0)" class="submit_btn" onclick="take_action(this)">로그아웃</a></h5>
				<h5 class="user-buttons"><a>마이페이지</a></h5>
				<h5 class="user-buttons"><a>장바구니</a></h5>
			</sec:authorize>
			
			
		</div>
		</form>
		<input type="hidden" name="userId" class="userId_input" id="userId_input" value="${userId}">
	</div>
</div>