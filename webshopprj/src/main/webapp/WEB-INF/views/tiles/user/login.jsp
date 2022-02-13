<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="content">
	<h1 class="login_label">회원 로그인</h1>
	<button id="NoLogin_btn">비회원으로</button><br>
	<form id="form" action="j_spring_security_check" method="post">
		<input class="login_input" name="username" placeholder="아이디" type="text"><br>
		<input class="login_input" name="password" placeholder="비밀번호" type="password"><br>
		<button type="submit" id="login_btn">로그인</button><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
	</form>
	
	<p>아이디 찾기</p>
	<p>비밀번호 찾기</p>
	<p>회원가입</p>	
</div>