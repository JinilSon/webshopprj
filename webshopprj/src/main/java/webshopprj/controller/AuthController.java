package webshopprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
	//Log4J는 현재 취약점으로 인한 사용불가(전 버전 취약점 발견)
	
	// spring에서는 redirect는 모두 get방식을 사용한다.
	@RequestMapping(value = "/login", method= RequestMethod.GET)				// 로그인 페이지
	public String loginGet(HttpServletRequest request) {
		// @RequestParam을 통해 매개변수의 값들을 입력받아 error 및 logout의 매개변수에 입력한다.(required=false는 매개변수가 없어도 무관하다는 것을 의미한다.)
		// 위의 처리를 하는 이유는 컨트롤러에 도착하기 전 filter를 거쳐서 도착하기에 filter가 입력해준 데이터 값을 통해 검증된 접근만 통과시킬 수 있다

		String prevUrl = (String)request.getHeader("REFERER");
		// 이전 페이지의 url 을 request객체에서 추출한다.(security에 가면서도 이전 페이지의 url을 가질 수 있다.)
		// 주의사항! : 링크를 클릭해서 들어온 경우만 알 수 있고, URL을 직접 치고 들어오는 경우는 null이다.
		request.getSession().setAttribute("prevPage", prevUrl);
		
		
		return "user.login";
	}
	
	
	
	// POST 방식 매핑으로, security를 거쳐서 들어온 경우의 매핑을 담당(ex)로그인 실패로, 리다이렉트)
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("user.login");
		String tmploginMsg = (String) request.getAttribute("loginFailMsg");
		
		if(tmploginMsg == null)
			mv.addObject("loginFailMsg", "");
		else
			mv.addObject("loginFailMsg", tmploginMsg);
		
		return mv;
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public void logout() {
		System.out.println("로그아웃됨");
	}
	
}
