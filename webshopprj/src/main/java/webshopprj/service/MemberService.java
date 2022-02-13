package webshopprj.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webshopprj.vo.UserVO;
import webshopprj.exception.UserIdNotFoundException;

@Service
public class MemberService implements UserDetailsService{
	@Autowired
	private UserService u_Service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("MemberService 접근");
		
		UserVO userVO = u_Service.getByIdVO(username);
		if(userVO == null)
			throw new UserIdNotFoundException(username);
		// 조회된 아이디가 없다 = 해당 아이디의 User가 없다
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		// SimpleGrantedAuthority는 계정이 가지고 있는 권한 목록을 리턴하는 역할을 한다.
		
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		// 여기서 아래에 로그인응답객체(이름, 비밀번호, 해당 사용자의 롤)로 만들어서 return 하면 된다.
		// 이렇게 return 하면 spring security 내에서 인증에 대한 판단을 한다.
		
		UserDetails user = new User(username, "{noop}" + userVO.getPw(), roles);
		// 여기서 {noop} security 5이상의 특성으로 PasswordEncoder를 찾는 식별자이다.
		return user;
	}

}
