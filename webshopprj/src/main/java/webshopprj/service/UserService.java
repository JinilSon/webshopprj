package webshopprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import webshopprj.dao.UserDao;
import webshopprj.entity.User;
import webshopprj.vo.UserDetailVO;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	

	public List<User> getAllUserDB() {
		return userDao.getAll();
	}
	// 모든 사용자에 대한 정보를 return(admin 사용자가 사용하기 위함)
	
	public User getById(String userId) {
		return userDao.get(userId);
	}
	// 검색된 사용자에 대한 정보를 return
	
	public UserDetailVO getByIdVO(String userId) {
		User user = getById(userId);
		
		if(user == null)
			return null;
		
		UserDetailVO userVO = new UserDetailVO(user.getId(), user.getPw());
		return userVO;
		
	}
	
	public void addProdDB() {
		
	}
	// 셀러는 한 번 올렸지만, 사이즈와 색상별로 나뉘어 DB에 저장하는 비즈니스 로직
	
}
