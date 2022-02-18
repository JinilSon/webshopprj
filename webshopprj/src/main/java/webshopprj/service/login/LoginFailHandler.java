package webshopprj.service.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

// LoginFailHandler�� AuthenticationFailureHandler�� ��ӹ޾� ���� ������ ���� �ڼ��� ������ �ѱ�� ������ �Ѵ�.
@Service
public class LoginFailHandler implements AuthenticationFailureHandler{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		System.out.println("LoginFailHandler");
		
		if(exception instanceof AuthenticationServiceException) {
			request.setAttribute("loginFailMsg", "�������� �ʴ� ������Դϴ�.");
		} else if(exception instanceof BadCredentialsException) {
			request.setAttribute("loginFailMsg", "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
		} else if(exception instanceof LockedException) {
			request.setAttribute("loginFailMsg", "��� �����Դϴ�.");
		} else if(exception instanceof DisabledException) {
			request.setAttribute("loginFailMsg", "��� �����Դϴ�.");
		} else if(exception instanceof AccountExpiredException) {
			request.setAttribute("loginFailMsg", "��� �����Դϴ�.");
		}
		
		System.out.println("LoginFailHandler ���� ");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
		dispatcher.forward(request, response);
		// �α��� ���� ������ ������, �α��� �������� forward
	}

}