package webshopprj;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webshopprj.entity.Product;
import webshopprj.entity.User;
import webshopprj.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class AdminServiceTest {

	@Autowired
	private AdminService a_service;
	
	private Product prod1;
	private Product prod2;
	private User user1;
	

	@Before
	public void setUp() throws Exception {
		prod1 = new Product("�����", "����", 15000, 10, "/img/img.jpg", "XX���ۻ翡�� ���� �� �����Դϴ�.");
		prod2 = new Product("û����", "û����", 20000, 8, null, "XXXû���� ����Ŀ�� û���� �Դϴ�.");
		user1 = new User("aaaa", "aaaa", "ȫ�浿", "1999-11-29", "010-2433-4522", "fdsafdsm@naver.com");
		
	}


	@Test
	public void test() {
		a_service.deleteAllDB();
		a_service.addUser(user1);
		a_service.addProd(prod1);
		a_service.addProd(prod2);
		assertThat(a_service.getAllUserDB().get(0).getName(), is(user1.getName()));
		
	}

}
