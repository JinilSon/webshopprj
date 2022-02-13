package webshopprj.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserIdNotFoundException extends NullPointerException{
	
	private static final long serialVersionUID = 1L;
	private final Logger log = LoggerFactory.getLogger(UserIdNotFoundException.class);
	
	public UserIdNotFoundException(String id) {
		log.debug(id + "��� ���̵��� ����ڸ� ã�� �� �����ϴ�.");
		System.out.println(id + "��� ���̵��� ����ڸ� ã�� �� �����ϴ�.");
	}

}
