package webshopprj.service.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;



@Service
public class UserLogoutHandler implements LogoutHandler{
	

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		
	}
	

}
