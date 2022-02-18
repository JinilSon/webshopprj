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
	

	public List<Product> getALLProduct() {
		return prodDao.getAll();
	}
	// ��� ��ǰ ��ü ��ȸ
	
	public Product getProductById(Integer prodId) {
		return prodDao.get(prodId);
	}
	// id �˻��� ���� ��ǰ ��ü ��ȸ
	
	public void addProduct(Product prod) {
		prodDao.add(prod);
	}
	// DB�� ��ǰ ��ü �Է�
	
	public void deleteAll() {
		prodDao.deleteAll();
	}
	// DB �ʱ�ȭ
	
}
