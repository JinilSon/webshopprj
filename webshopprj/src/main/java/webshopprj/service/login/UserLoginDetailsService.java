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
//  ������ ��ü UserDetails�� ���� �� �����ϴ� Ŭ����
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws AuthenticationServiceException {
		
		// spring security���� ����� { id, password, authorities} �� ������ ��ü�� DB���� ����
		UserDetailVO userVO = userService.getUserDetailVOById(username);
		
		if(userVO == null) {	// ��ü�� null(��, id�� �ش��ϴ� ����ڰ� DB�� ��ϵǾ� ���� �ʴٸ�)�̸�, null�� ����
			return null;
		}
		
//		List<String> tmpAuth = Arrays.asList("USER");		// �ӽÿ� ���� ����(DB�ȿ� ���ִ� ��)
//		userVO.setAuth(tmpAuth);
		
		return userVO;
	}

}
