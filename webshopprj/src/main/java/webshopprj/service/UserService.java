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
	// UserService������ ����ڿ��� �����ֱ� ���� ���ѱ����� �����ϰ� �Ѵ�.
	
	public void addProdDB() {
		
	}
	// ������ �� �� �÷�����, ������� ���󺰷� ������ DB�� �����ϴ� ����Ͻ� ����
	
}
