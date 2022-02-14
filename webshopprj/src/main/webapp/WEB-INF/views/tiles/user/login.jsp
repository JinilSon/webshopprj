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
		<label id="auto_login" class="login_sub_button_label"><input type="checkbox" name="remember-me" id="auto_login_checkbox" >자동로그인</label>
		<div id="login_sub_button">
			<a href="#" class="login_sub_button_label">아이디 찾기</a>
			<a href="#" class="login_sub_button_label">비밀번호 찾기</a>
			<a href="#" class="login_sub_button_label">회원가입</a>
		</div>	
	</form>
	
</div>