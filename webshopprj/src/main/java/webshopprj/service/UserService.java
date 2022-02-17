package webshopprj.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshopprj.dao.UserDao;
import webshopprj.entity.User;
import webshopprj.vo.UserDetailVO;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getAllUser() {
		return userDao.getAll();
	}
	// 모든 사용자에 대한 데이터 조회
	
	public User getUserById(String userId) {
		return userDao.get(userId);
	}
	// 매개변수와 같은 이름의 id값을 가진 객체 조회
	
	public UserDetailVO getUserDetailVOById(String userId) {
		User user = getUserById(userId);
		
		if(user == null)
			return null;
		
		UserDetailVO userVO = new UserDetailVO(user.getId(), user.getPw());
		List<String> tmpAuth = Arrays.asList(user.getAuthList());		// 임시용 권한 설정(DB안에 들어가있는 것)
		userVO.setAuth(tmpAuth);
		
		return userVO;
	}
	// 로그인 처리를 위한 UserDetail 전용 VO 객체 조회
	
	public void addUser(User user)
	{
		userDao.add(user);
	}
	// 사용자 추가 메서드
	
	public void deleteAll()
	{
		userDao.deleteAll();
	}
	// 사용자 전체 제거 메서드
	

	// 셀러는 한 번 올렸지만, 사이즈와 색상별로 나뉘어 DB에 저장하는 비즈니스 로직이 필요(이 위치)
	
}
