package webshopprj.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import webshopprj.vo.UserDetailVO;

@Service
public class UserLoginDetailsService implements UserDetailsService{
	@Autowired
	private UserService u_Service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws AuthenticationServiceException {
		
		// spring security에서 사용할 { id, password, authorities} 로 구성된 객체
		UserDetailVO userVO = u_Service.getByIdVO(username);
		
		if(userVO == null) {
			return null;
		}
		
		List<String> tmpAuth = Arrays.asList("USER");
		userVO.setAuth(tmpAuth);
		

		System.out.println("MemberService 처리완료");
		return userVO;
	}

}
