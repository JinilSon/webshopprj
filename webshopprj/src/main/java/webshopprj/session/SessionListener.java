package webshopprj.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// @WebListener�� ����ϸ� web.xml�� ��ϵ��� �ʾƵ� �ڵ����� ����Ǵ� ������ ���� �� �ִ�.(web.xml�� ��ϵ� listener�� ������ ����̴�.)
@WebListener
public class SessionListener implements HttpSessionListener{
	

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created");
		se.getSession().setMaxInactiveInterval(10);
		// 10�ʰ� ������ ������ ���� ����
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session destroyed");
	}

}
