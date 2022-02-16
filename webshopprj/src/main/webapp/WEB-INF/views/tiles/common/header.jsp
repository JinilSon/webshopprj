<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header">			<!-- header 부분 -->
	<div class="header-content">
		<div class="header-left">
			<h1><a href="#">Webshopprj</a></h1>
		</div>
		<input class="header-left-search" type="text" value="" placeholder=" 검색" size="20" maxlength="20" />
		<div class="user-buttons">
			<h5><a href="/login">로그인</a><h5>
			<h5><a>마이페이지</a><h5>
			<h5><a>장바구니</a><h5>
		</div>
		<input type="hidden" name="userId" class="userId_input"  value="${userId}">
	</div>
</div>