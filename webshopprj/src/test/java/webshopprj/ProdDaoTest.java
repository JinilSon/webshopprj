package webshopprj;


import static org.hamcrest.CoreMatchers.*;
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

import webshopprj.dao.ProdDao;
import webshopprj.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)	//RunWith는 JUNIT이 내장된 runner가 아닌 사용자 지정의 runner와 동작할 수 있게 한다.(springframework와 연동)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class ProdDaoTest {
	
	@Autowired
	private ProdDao dao;
	
	private Product prod1;
	private Product prod2;
	

	@BeforeClass	// 테스트 클래스 시작 시 한 번만
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before			// 테스트 케이스 시작 전
	public void setUp() throws Exception {
		prod1 = new Product();
		prod1.setTitle("흰셔츠");
		prod1.setCategory("셔츠");
		prod1.setDiscount(10);
		prod1.setPicture(null);
		prod1.setDiscription("dfsa");
		prod1.setPrice(10);
		prod2 = new Product();
	}
	
	@Test			// 테스트 케이스
	public void test() {
		dao.deleteAll();
		dao.add(prod1);
		try {
			prod2 = dao.get(1);
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		assertThat(prod1.getDiscount(), is(prod2.getDiscount()));
		
	}
	

	@After			// 테스트 케이스 종료 후
	public void tearDown() throws Exception {
	}
	
	@AfterClass		// 테스트 클래스 클래스 종료 전 한번 만
	public static void tearDownAfterClass() throws Exception {
	}



}
