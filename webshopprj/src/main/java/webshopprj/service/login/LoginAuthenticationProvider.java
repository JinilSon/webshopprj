package webshopprj.service.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import webshopprj.vo.UserDetailVO;

@Service
public class LoginAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// 사용자가 입력한 정보를 authentication 객체에서 로드
		String userId = authentication.getName();
		String userPw = (String) authentication.getCredentials();
		
		// DB에서 가져온 VO 객체
		UserDetailVO vo = (UserDetailVO) service.loadUserByUsername(userId);
		
		// 빈 초기화가 되지 않거나, vo에 조회된 값(DB)이 없으면 AuthenticationServiceException
		// ID나 PW가 알맞지 않으면, BadCredentialsException
		if(service == null || vo == null) {
			throw new AuthenticationServiceException(userId);
		} else if(!userId.equals(vo.getUsername()) || !encoder.matches(userPw, vo.getPassword())){
			throw new BadCredentialsException(userId);
		} else if(!vo.isAccountNonLocked()) {
			throw new LockedException(userId);
		} else if(!vo.isEnabled()) {
			throw new DisabledException(userId);
		} else if(!vo.isAccountNonExpired()) {
			throw new AccountExpiredException(userId);
		} else if(!vo.isCredentialsNonExpired()) {
			throw new CredentialsExpiredException(userId);
		}
		
		vo.setPw(null);
		// vo 객체 재사용을 위한 패스워드 초기화
		
		Authentication auth = new UsernamePasswordAuthenticationToken(vo, null, vo.getAuthorities());
		// 최종 리턴을 위한 Authentication 객체
		
		return auth;
	}
	// 인증을 수행하는 메서드
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
		// 제출하는 클래스 타입이 UsernamePasswordAuthenticationToken 타입인지 확인
	}
	// authenticate 메소드에서 반환한 객체가 유효한 타입이 맞는지 검사
	// 인증 실패 시, loginFailHandler로 연결

}
