package webshopprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshopprj.dao.ProdDao;
import webshopprj.dao.UserDao;
import webshopprj.entity.Product;
import webshopprj.entity.User;
import webshopprj.vo.UserVO;

@Service
public class AdminService {
	
	@Autowired
	private ProdDao prodDao;
	
	@Autowired
	private UserDao userDao;

	
	public List<Product> getAllProdDB() {
		return prodDao.getAll();
	}
	
	public List<User> getAllUserDB(){
		return userDao.getAll();
	}
	
	public void addUser(User user) {
		userDao.add(user);
	}
	
	public void addProd(Product prod) {
		prodDao.add(prod);
	}
	
	public void deleteAllProdDB() {
		prodDao.deleteAll();
	}
	
	public void deleteAllUserDB() {
		userDao.deleteAll();
	}
	
	public void deleteAllDB() {
		prodDao.deleteAll();
		userDao.deleteAll();
	}
	// 여기까지는 순수 DAO 기능
	
}
