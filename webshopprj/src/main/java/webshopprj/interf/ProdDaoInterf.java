package webshopprj.interf;

import java.util.List;

import webshopprj.entity.Product;

public interface ProdDaoInterf {
		void add(Product prod);
		void update(Product prod);
		Product get(String id);
		List<Product> getAll();
		void deleteAll();
		int getCount();
		
	// ���� �������̽��� ��ӹ޴� Ŭ�������� throws �� ����Ͽ� ȣ�� Ŭ�������� ���ܸ� �Ѱ��ַ��� �ϴ� ���,
	// �������̽����� �����ϰ� throws���� ������ �־�� �ϴ� ������ �ִ�.
	// 		try-catch�� ��� �ش� Ŭ���� ������ ó������ ���� �������̽��� �������� �ʴ´�.

}

