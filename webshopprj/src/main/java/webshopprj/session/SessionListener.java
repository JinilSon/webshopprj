package webshopprj.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// @WebListener를 사용하면 web.xml에 등록되지 않아도 자동으로 실행되는 데몬을 만들 수 있다.(web.xml에 등록된 listener와 동일한 기능이다.)
@WebListener
public class SessionListener implements HttpSessionListener{
	

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created");
		se.getSession().setMaxInactiveInterval(10);
		// 10초간 움직임 없으면 세션 종료
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session destroyed");
	}

}
