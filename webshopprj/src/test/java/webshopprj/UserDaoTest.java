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

import webshopprj.entity.User;
import webshopprj.service.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)	//RunWith는 JUNIT이 내장된 runner가 아닌 사용자 지정의 runner와 동작할 수 있게 한다.(springframework와 연동)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class UserDaoTest {
	
	@Autowired
	private UserDao dao;
	
	private User user1;
	private User user2;
	

	@BeforeClass	// 테스트 클래스 시작 시 한 번만
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before			// 테스트 케이스 시작 전
	public void setUp() throws Exception {
		user1 = new User();
		user1.setId("fdsajlfd");
		user1.setPw("dosjaofdf");
		user1.setName("홍길동");
		user1.setBirthdate("1999-11-29");
		user1.setPhonenum("010-2433-453");
		user1.setEmail("djklsa@naver.com");
		user1.setB_item_num("1,2,3");
		user2 = new User();
	}
	
	@Test			// 테스트 케이스
	public void test() {
		dao.deleteAll();
		dao.add(user1);
		try {
			user2 = dao.get(user1.getId());
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		assertThat(user1.getId(), is(user2.getId()));
		
	}
	

	@After			// 테스트 케이스 종료 후
	public void tearDown() throws Exception {
	}
	
	@AfterClass		// 테스트 클래스 클래스 종료 전 한번 만
	public static void tearDownAfterClass() throws Exception {
	}



}
