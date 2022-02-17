package webshopprj;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webshopprj.entity.User;
import webshopprj.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)	//RunWith는 JUNIT이 내장된 runner가 아닌 사용자 지정의 runner와 동작할 수 있게 한다.(springframework와 연동)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class UserDaoTest {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private User user1;
	private User user2;
	

	@BeforeClass	// 테스트 클래스 시작 시 한 번만
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before			// 테스트 케이스 시작 전
	public void setUp() throws Exception {
		String pw = "aaaa";
		String encodedPw = encoder.encode(pw);
		user1 = new User("aaaa", encodedPw, "홍길동", "1999-11-29", "010-2433-4522", "fdsafdsm@naver.com", "USER");
	}
	
	@Test			// 테스트 케이스
	public void test() {
		userService.deleteAll();
		userService.addUser(user1);
		try {
			user2 = userService.getUserById(user1.getId());
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		assertThat(user1.getPw(), is(user2.getPw()));
		// 업로드한 pw와 업로드 된 pw와의 비교
		assertTrue(encoder.matches("aaaa", user2.getPw()));
		// 업로드한 pw와 업로드 된 pw와의 비교2(version.encode);
	}
	

	@After			// 테스트 케이스 종료 후
	public void tearDown() throws Exception {
	}
	
	@AfterClass		// 테스트 클래스 클래스 종료 전 한번 만
	public static void tearDownAfterClass() throws Exception {
	}



}
