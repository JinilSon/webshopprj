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

@RunWith(SpringJUnit4ClassRunner.class)	//RunWith�� JUNIT�� ����� runner�� �ƴ� ����� ������ runner�� ������ �� �ְ� �Ѵ�.(springframework�� ����)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class UserDaoTest {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private User user1;
	private User user2;
	

	@BeforeClass	// �׽�Ʈ Ŭ���� ���� �� �� ����
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before			// �׽�Ʈ ���̽� ���� ��
	public void setUp() throws Exception {
		String pw = "aaaa";
		String encodedPw = encoder.encode(pw);
		user1 = new User("aaaa", encodedPw, "ȫ�浿", "1999-11-29", "010-2433-4522", "fdsafdsm@naver.com", "USER");
	}
	
	@Test			// �׽�Ʈ ���̽�
	public void test() {
		userService.deleteAll();
		userService.addUser(user1);
		try {
			user2 = userService.getUserById(user1.getId());
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		assertThat(user1.getPw(), is(user2.getPw()));
		// ���ε��� pw�� ���ε� �� pw���� ��
		assertTrue(encoder.matches("aaaa", user2.getPw()));
		// ���ε��� pw�� ���ε� �� pw���� ��2(version.encode);
	}
	

	@After			// �׽�Ʈ ���̽� ���� ��
	public void tearDown() throws Exception {
	}
	
	@AfterClass		// �׽�Ʈ Ŭ���� Ŭ���� ���� �� �ѹ� ��
	public static void tearDownAfterClass() throws Exception {
	}



}
