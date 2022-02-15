package webshopprj.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// login 절차에서 사용하기 위한 아이디 비번 객체
public class UserDetailVO implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	private List<GrantedAuthority> authList;
	// SimpleGrantedAuthority는 계정이 가지고 있는 권한 목록을 리턴하는 역할을 한다.
	
	
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
	// 여기서 {noop}은 security 5이상의 특성으로 PasswordEncoder를 찾는 식별자이다.
	
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
	// 계정 만료 유무(true : 사용가능, false : 만료)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	// 계정 잠금 유무(true : 사용가능, false : 잠금)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	// 패스워드 만료 유무(true : 사용가능, false : 만료)
	@Override
	public boolean isEnabled() {
		return true;
	}
	// 계정 활성화 유무(true : 사용가능, false : 비활성화)
}