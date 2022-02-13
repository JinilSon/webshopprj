package webshopprj.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserIdNotFoundException extends NullPointerException{
	
	private static final long serialVersionUID = 1L;
	private final Logger log = LoggerFactory.getLogger(UserIdNotFoundException.class);
	
	public UserIdNotFoundException(String id) {
		log.debug(id + "라는 아이디의 사용자를 찾을 수 없습니다.");
		System.out.println(id + "라는 아이디의 사용자를 찾을 수 없습니다.");
	}

}
