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
	// 모든 제품 객체 조회
	
	public Product getProductById(Integer prodId) {
		return prodDao.get(prodId);
	}
	// id 검색에 따른 제품 객체 조회
	
	public void addProduct(Product prod) {
		prodDao.add(prod);
	}
	// DB에 제품 객체 입력
	
	public void deleteAll() {
		prodDao.deleteAll();
	}
	// DB 초기화
	
}
