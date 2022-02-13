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
	// UserService������ ����ڿ��� �����ֱ� ���� ���ѱ����� �����ϰ� �Ѵ�.
	
	public Product getById(Integer prodId) {
		return prodDao.get(prodId);
	}
	
	public void addProdDB() {
		
	}
}
