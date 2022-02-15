package webshopprj.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// login �������� ����ϱ� ���� ���̵� ��� ��ü
public class UserDetailVO implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	private List<GrantedAuthority> authList;
	// SimpleGrantedAuthority�� ������ ������ �ִ� ���� ����� �����ϴ� ������ �Ѵ�.
	
	
	public UserDetailVO(String id, String pw) {
		this.id = id;
		this.pw = "{noop}" + pw;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = "{noop}" + pw;
	}
	// ���⼭ {noop}�� security 5�̻��� Ư������ PasswordEncoder�� ã�� �ĺ����̴�.
	
	public void setAuth(List<String> authStringList) {
		authList = new ArrayList<GrantedAuthority>();
		for(int i=0; i<authList.size(); i++) {
			authList.add(new SimpleGrantedAuthority(authStringList.get(i)));
		}
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authList;
	}
	@Override
	public String getPassword() {
		return pw;
	}
	@Override
	public String getUsername() {
		return id;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	// ���� ���� ����(true : ��밡��, false : ����)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	// ���� ��� ����(true : ��밡��, false : ���)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	// �н����� ���� ����(true : ��밡��, false : ����)
	@Override
	public boolean isEnabled() {
		return true;
	}
	// ���� Ȱ��ȭ ����(true : ��밡��, false : ��Ȱ��ȭ)
}