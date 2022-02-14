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

// LoginFailHandler�� AuthenticationFailureHandler�� ��ӹ޾� ���� ������ ���� �ڼ��� ������ �ѱ�� ������ �Ѵ�.
public class LoginFailHandler implements AuthenticationFailureHandler{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		if(exception instanceof AuthenticationServiceException) {
			request.setAttribute("loginFailMsg", "�������� �ʴ� ������Դϴ�.");
		} else if(exception instanceof BadCredentialsException) {
			request.setAttribute("loginFailMsg", "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
		dispatcher.forward(request, response);
		// �α��� ���� ������ ������, �α��� �������� forward
	}

}
