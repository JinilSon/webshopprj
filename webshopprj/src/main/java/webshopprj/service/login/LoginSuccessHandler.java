package webshopprj.service.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// request ��ü�� �������� �� ������ ������ ������
		// response ��ü�� �� ������ �������� ������ ����(�ַ� redirect �� url)
		
//		AuthenticationSuccessHandler Ŭ������ ���� �޼ҵ� Authentication ��ü��
//		������ �ִ� �Ӽ��� ����Ʈ
//		String getName() : ����� ID ��ȯ
//		Collection<> getAuthorities() : ����� ���� ����Ʈ ��ȯ
//		Object getPrincipal() : UserDetail ��ü ��ȯ(Provider���� Authentication ��ü�� ��Ȯ�� �������� ��츸 ��� ����)
//		Object getDetilas() : IP, ���� ID�� ���� WebAuthenticationDetilas ��ü ��ȯ(Ÿ�� ĳ������ �ʿ�)
		
//		�α����� �� ��, �� ������ ������ �� �� ������ ���� ���� ���и� �� ��, ������ �� �� �ִ�.
//		�̷��� ���� ���е��� ���ǿ� ������ ����ǰ� �ϴ� ����� ���´�.
//		�� �� �α��ο� �����ϴ��� ���ǿ� ������ ���� ä�� �Ѿ ���� ����.
		
		
		
		String uri = "/main";
		// ����Ʈ uri��, ���ǿ��� uri�� �������� ���� ��쿡 ����� uri(������ target-url)
		
		
		// ���� ������ ���� ������ ��û -> �α��� ȭ��(���ͼ�Ʈ) -> �α��� ���� -> �˸´� ȭ�鿡 �����̷�Ʈ
		// ex) ���������� Ŭ�� -> ����X -> �α��� ȭ��(���ͼ�Ʈ) -> �α��� ���� -> ������������ �ٷ� �̵�
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		// �������� ���� ��û�� security�� ���� �������Ѵ�.
		// �� ��, ���ͼ�Ʈ �� ��û ������ url�� requstCache�� ���� �ٽ� �ҷ��� �� �ִ�.
		
		
		
		// �ܼ� �α��� ������������ �α��� ��û -> �α��� ���� -> �α��� ���� ������
		// ex) �α��� Ŭ�� -> �α���ȭ�� -> �α��� ���� -> �α��� ���� �������� �ٷ� �̵�
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		// �α��� ��ư ���� �������� ����� ������ get
		
		if(prevPage != null)
			request.getSession().removeAttribute("prevPage");
		
		
		// �� �ΰ����� �ƴϰ�, �α��� â�� ���ã�� �ص״ٰų� �ϴ� ���(����Ʈ �������� �����̷�Ʈ)
		// ex) �α��� â���� �̵��ϱ� ���� �������� �츮 ���� ���ָ� �Ѿ�� ���,
		// �α��� ���ã�� Ŭ�� -> �α��� ȭ�� -> �α��� ���� -> ����Ʈ ������(����)���� �ٷ� �̵�
		if(savedRequest != null) 
			uri = savedRequest.getRedirectUrl();
		else if(prevPage != null && !prevPage.equals(""))
			uri = prevPage;
			
		
		System.out.println("prevPage : " + prevPage);
		System.out.println("uri : " + uri);
		System.out.println("username : " + authentication.getName());
		
		request.getSession().setAttribute("userId", authentication.getName());
		
		response.sendRedirect(uri);
		
		
		
		
	}
	

}
