package webshopprj;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webshopprj.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class AdminServiceTest {

	@Autowired
	private AdminService adminService;
	

	@Before
	public void setUp() throws Exception {
		
	}


	@Test
	public void test() {
		
	}

}
