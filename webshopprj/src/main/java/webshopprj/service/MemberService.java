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
		
		System.out.println("MemberService ����");
		
		UserVO userVO = u_Service.getByIdVO(username);
		if(userVO == null)
			throw new UserIdNotFoundException(username);
		// ��ȸ�� ���̵� ���� = �ش� ���̵��� User�� ����
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		// SimpleGrantedAuthority�� ������ ������ �ִ� ���� ����� �����ϴ� ������ �Ѵ�.
		
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		// ���⼭ �Ʒ��� �α������䰴ü(�̸�, ��й�ȣ, �ش� ������� ��)�� ���� return �ϸ� �ȴ�.
		// �̷��� return �ϸ� spring security ������ ������ ���� �Ǵ��� �Ѵ�.
		
		UserDetails user = new User(username, "{noop}" + userVO.getPw(), roles);
		// ���⼭ {noop} security 5�̻��� Ư������ PasswordEncoder�� ã�� �ĺ����̴�.
		return user;
	}

}
