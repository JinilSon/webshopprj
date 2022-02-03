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
		
	// 만약 인터페이스를 상속받는 클래스에서 throws 를 사용하여 호출 클래스에게 예외를 넘겨주려고 하는 경우,
	// 인터페이스에도 동일하게 throws문을 선언해 주어야 하는 단점이 있다.
	// 		try-catch를 사용 해당 클래스 내에서 처리했을 경우는 인터페이스가 변형되지 않는다.

}

