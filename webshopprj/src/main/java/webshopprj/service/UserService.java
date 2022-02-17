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
	// ��� ����ڿ� ���� ������ return(admin ����ڰ� ����ϱ� ����)
	
	public User getById(String userId) {
		return userDao.get(userId);
	}
	// �˻��� ����ڿ� ���� ������ return
	
	public UserDetailVO getByIdVO(String userId) {
		User user = getById(userId);
		
		if(user == null)
			return null;
		
		UserDetailVO userVO = new UserDetailVO(user.getId(), user.getPw());
		return userVO;
		
	}
	
	public void addProdDB() {
		
	}
	// ������ �� �� �÷�����, ������� ���󺰷� ������ DB�� �����ϴ� ����Ͻ� ����
	
}
