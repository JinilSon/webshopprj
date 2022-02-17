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
		// request 객체는 브라우저가 웹 서버에 보내는 정보를
		// response 객체는 웹 서버가 브라우저에 보내는 정보(주로 redirect 될 url)
		
//		AuthenticationSuccessHandler 클래스의 하위 메소드 Authentication 객체가
//		가지고 있는 속성들 리스트
//		String getName() : 사용자 ID 반환
//		Collection<> getAuthorities() : 사용자 권한 리스트 반환
//		Object getPrincipal() : UserDetail 객체 반환(Provider에서 Authentication 객체에 정확히 전송했을 경우만 사용 가능)
//		Object getDetilas() : IP, 세션 ID를 가진 WebAuthenticationDetilas 객체 반환(타입 캐스팅이 필요)
		
//		로그인을 할 때, 한 번만에 성공할 수 도 있지만 여러 번의 실패를 한 후, 성공할 수 도 있다.
//		이러한 이전 실패들은 세션에 에러를 저장되게 하는 결과를 낳는다.
//		이 후 로그인에 성공하더라도 세션에 에러가 남은 채로 넘어갈 수는 없다.
		
		
		
		String uri = "/main";
		// 디폴트 uri로, 세션에서 uri를 가져오지 못할 경우에 사용할 uri(일종의 target-url)
		
		
		// 접근 권한이 없는 페이지 요청 -> 로그인 화면(인터셉트) -> 로그인 성공 -> 알맞는 화면에 리다이렉트
		// ex) 마이페이지 클릭 -> 권한X -> 로그인 화면(인터셉트) -> 로그인 성공 -> 마이페이지로 바로 이동
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		// 인증되지 않은 요청은 security에 의해 검증당한다.
		// 이 때, 인터셉트 된 요청 페이지 url은 requstCache로 값을 다시 불러올 수 있다.
		
		
		
		// 단순 로그인 페이지에서의 로그인 요청 -> 로그인 성공 -> 로그인 이전 페이지
		// ex) 로그인 클릭 -> 로그인화면 -> 로그인 성공 -> 로그인 이전 페이지로 바로 이동
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		// 로그인 버튼 눌러 접속했을 경우의 데이터 get
		
		if(prevPage != null)
			request.getSession().removeAttribute("prevPage");
		
		
		// 위 두가지가 아니고, 로그인 창을 즐겨찾기 해뒀다거나 하는 경우(디폴트 페이지로 리다이렉트)
		// ex) 로그인 창으로 이동하기 전의 페이지가 우리 서버 범주를 넘어서는 경우,
		// 로그인 즐겨찾기 클릭 -> 로그인 화면 -> 로그인 성공 -> 디폴트 페이지(메인)으로 바로 이동
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
