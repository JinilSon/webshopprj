package webshopprj;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webshopprj.entity.Product;
import webshopprj.service.ProdService;

@RunWith(SpringJUnit4ClassRunner.class)	//RunWith�� JUNIT�� ����� runner�� �ƴ� ����� ������ runner�� ������ �� �ְ� �Ѵ�.(springframework�� ����)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class ProdDaoTest {
	
	@Autowired
	private ProdService prodService;
	
	private Product prod1;
	private Product prod2;
	private Product get_prod1;
	

	@BeforeClass	// �׽�Ʈ Ŭ���� ���� �� �� ����
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before			// �׽�Ʈ ���̽� ���� ��
	public void setUp() throws Exception {
		prod1 = new Product("�����", "����", 15000, 10, "/img/img.jpg", "XX���ۻ翡�� ���� �� �����Դϴ�.");
		prod2 = new Product("û����", "û����", 20000, 8, null, "XXXû���� ����Ŀ�� û���� �Դϴ�.");
	}
	
	@Test			// �׽�Ʈ ���̽�
	public void test() {
		prodService.deleteAll();
		prodService.addProduct(prod1);
		prodService.addProduct(prod2);
		try {
			get_prod1 = prodService.getProductById(1);
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		assertThat(prod1.getDiscount(), is(get_prod1.getDiscount()));
		
	}
	

	@After			// �׽�Ʈ ���̽� ���� ��
	public void tearDown() throws Exception {
	}
	
	@AfterClass		// �׽�Ʈ Ŭ���� Ŭ���� ���� �� �ѹ� ��
	public static void tearDownAfterClass() throws Exception {
	}



}
