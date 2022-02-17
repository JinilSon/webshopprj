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
	// ��� ����ڿ� ���� ������ ��ȸ
	
	public User getUserById(String userId) {
		return userDao.get(userId);
	}
	// �Ű������� ���� �̸��� id���� ���� ��ü ��ȸ
	
	public UserDetailVO getUserDetailVOById(String userId) {
		User user = getUserById(userId);
		
		if(user == null)
			return null;
		
		UserDetailVO userVO = new UserDetailVO(user.getId(), user.getPw());
		List<String> tmpAuth = Arrays.asList(user.getAuthList());		// �ӽÿ� ���� ����(DB�ȿ� ���ִ� ��)
		userVO.setAuth(tmpAuth);
		
		return userVO;
	}
	// �α��� ó���� ���� UserDetail ���� VO ��ü ��ȸ
	
	public void addUser(User user)
	{
		userDao.add(user);
	}
	// ����� �߰� �޼���
	
	public void deleteAll()
	{
		userDao.deleteAll();
	}
	// ����� ��ü ���� �޼���
	

	// ������ �� �� �÷�����, ������� ���󺰷� ������ DB�� �����ϴ� ����Ͻ� ������ �ʿ�(�� ��ġ)
	
}
