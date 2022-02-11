package webshopprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshopprj.dao.ProdDao;
import webshopprj.entity.Product;

@Service
public class UserService {

	@Autowired
	private ProdDao prodDao;
	

	public List<Product> getAllProdDB() {
		return prodDao.getAll();
	}
	// UserService에서는 사용자에게 보여주기 위한 권한까지만 접근하게 한다.
	
	public void addProdDB() {
		
	}
	// 셀러는 한 번 올렸지만, 사이즈와 색상별로 나뉘어 DB에 저장하는 비즈니스 로직
	
}
