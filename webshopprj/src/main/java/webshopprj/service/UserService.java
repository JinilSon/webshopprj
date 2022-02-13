package webshopprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshopprj.dao.UserDao;
import webshopprj.entity.User;
import webshopprj.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	

	public List<User> getAllUserDB() {
		return userDao.getAll();
	}
	// ��� ����ڿ� ���� ������ return(admin ����ڰ� ����ϱ� ����)
	
	public User getById(String userId) {
		return userDao.get(userId);
	}
	// �˻��� ����ڿ� ���� ������ return
	
	public UserVO getByIdVO(String userId) {
		User user = getById(userId);
		UserVO userVO = new UserVO(user.getId(), user.getPw());
		
		return userVO;
		
	}
	
	public void addProdDB() {
		
	}
	// ������ �� �� �÷�����, ������� ���󺰷� ������ DB�� �����ϴ� ����Ͻ� ����
	
}
