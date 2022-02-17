package webshopprj.service.login;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import webshopprj.service.UserService;
import webshopprj.vo.UserDetailVO;

@Service
public class UserLoginDetailsService implements UserDetailsService{
//  인증용 객체 UserDetails를 생성 및 제출하는 클래스
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws AuthenticationServiceException {
		
		// spring security에서 사용할 { id, password, authorities} 로 구성된 객체를 DB에서 추출
		UserDetailVO userVO = userService.getUserDetailVOById(username);
		
		if(userVO == null) {	// 객체가 null(즉, id에 해당하는 사용자가 DB에 등록되어 있지 않다면)이면, null을 리턴
			return null;
		}
		
//		List<String> tmpAuth = Arrays.asList("USER");		// 임시용 권한 설정(DB안에 들어가있는 것)
//		userVO.setAuth(tmpAuth);
		
		return userVO;
	}

}
