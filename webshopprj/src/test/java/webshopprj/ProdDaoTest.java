package webshopprj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webshopprj.service.ProdDao;

@RunWith(SpringJUnit4ClassRunner.class)	//RunWith�� JUNIT�� ����� runner�� �ƴ� ����� ������ runner�� ������ �� �ְ� �Ѵ�.(springframework�� ����)
@ContextConfiguration("file:src/main/webapp/WEB-INF/context/service-context.xml")
public class ProdDaoTest {
	
	@Autowired
	public ProdDao dao;

	@BeforeClass	// �׽�Ʈ Ŭ���� ���� �� �� ����
	public static void setUpBeforeClass() throws Exception {
	}

	
	@Before			// �׽�Ʈ ���̽� ���� ��
	public void setUp() throws Exception {
	}
	
	@Test			// �׽�Ʈ ���̽�
	public void test() {
		System.out.println("aa");
	}
	

	@After			// �׽�Ʈ ���̽� ���� ��
	public void tearDown() throws Exception {
	}
	
	@AfterClass		// �׽�Ʈ Ŭ���� Ŭ���� ���� �� �ѹ� ��
	public static void tearDownAfterClass() throws Exception {
	}



}
