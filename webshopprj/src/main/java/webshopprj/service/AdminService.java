package webshopprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshopprj.dao.ProdDao;
import webshopprj.dao.UserDao;
import webshopprj.entity.Product;
import webshopprj.entity.User;

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
	
}
