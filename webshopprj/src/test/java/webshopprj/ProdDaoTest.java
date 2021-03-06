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

@RunWith(SpringJUnit4ClassRunner.class)	//RunWith는 JUNIT이 내장된 runner가 아닌 사용자 지정의 runner와 동작할 수 있게 한다.(springframework와 연동)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class ProdDaoTest {
	
	@Autowired
	private ProdService prodService;
	
	private Product prod1;
	private Product prod2;
	private Product get_prod1;
	

	@BeforeClass	// 테스트 클래스 시작 시 한 번만
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before			// 테스트 케이스 시작 전
	public void setUp() throws Exception {
		prod1 = new Product("흰셔츠", "셔츠", 15000, "S", "브라운", 20, "/img/img.jpg", "XX제작사에서 만든 흰 셔츠입니다.");
		prod2 = new Product("청바지", "청바지", 20000, "M", "실버", 50, null, "XXX청바지 메이커의 청바지 입니다.");
	}					// 타이틀, 카테고리, 가격, 사이즈, 색상, 개수, img_url, 설명
	
	@Test			// 테스트 케이스
	public void test() {
		prodService.deleteAll();
		prodService.addProduct(prod1);
		prodService.addProduct(prod2);
		try {
			get_prod1 = prodService.getProductById(1);
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		assertThat(prod1.getCategory(), is(get_prod1.getCategory()));
		
	}
	

	@After			// 테스트 케이스 종료 후
	public void tearDown() throws Exception {
	}
	
	@AfterClass		// 테스트 클래스 클래스 종료 전 한번 만
	public static void tearDownAfterClass() throws Exception {
	}



}
