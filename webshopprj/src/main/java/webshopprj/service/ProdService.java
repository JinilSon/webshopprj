package webshopprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import webshopprj.dao.ProdDao;
import webshopprj.entity.Product;

@Controller
public class ProdService {

	@Autowired
	private ProdDao prodDao;
	

	public List<Product> getAllProdDB() {
		return prodDao.getAll();
	}
	// UserService에서는 사용자에게 보여주기 위한 권한까지만 접근하게 한다.
	
	public Product getById(Integer prodId) {
		return prodDao.get(prodId);
	}
	
	public void addProdDB() {
		
	}
}
