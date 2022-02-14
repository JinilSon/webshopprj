package webshopprj.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

// LoginFailHandler는 AuthenticationFailureHandler를 상속받아 실패 사유에 대한 자세한 설명을 넘기는 역할을 한다.
public class LoginFailHandler implements AuthenticationFailureHandler{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		if(exception instanceof AuthenticationServiceException) {
			request.setAttribute("loginFailMsg", "존재하지 않는 사용자입니다.");
		} else if(exception instanceof BadCredentialsException) {
			request.setAttribute("loginFailMsg", "아이디 또는 비밀번호가 틀립니다.");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
		dispatcher.forward(request, response);
		// 로그인 실패 사유를 가지고, 로그인 페이지로 forward
	}

}
