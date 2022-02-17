package webshopprj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import webshopprj.vo.UserDetailVO;

public class LoginAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// ����ڰ� �Է��� ������ authentication ��ü���� �ε�
		String userId = authentication.getName();
		String userPw = (String) authentication.getCredentials();
		
		// DB���� ������ VO ��ü
		UserDetailVO vo = (UserDetailVO) service.loadUserByUsername(userId);
		
		if(service == null || !userId.equals(vo.getUsername())
				|| !encoder.matches(userPw, vo.getPassword())){
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
		// vo ��ü ������ ���� �н����� �ʱ�ȭ
		
		Authentication auth = new UsernamePasswordAuthenticationToken(vo, null, vo.getAuthorities());
		// ���� ������ ���� Authentication ��ü
		
		return auth;
	}
	// ������ �����ϴ� �޼���
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
		// �����ϴ� Ŭ���� Ÿ���� UsernamePasswordAuthenticationToken Ÿ������ Ȯ��
	}
	// authenticate �޼ҵ忡�� ��ȯ�� ��ü�� ��ȿ�� Ÿ���� �´��� �˻�
	// ���� ���� ��, loginFailHandler�� ����

}
