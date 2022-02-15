package webshopprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
	//Log4J는 현재 취약점으로 인한 사용불가(전 버전 취약점 발견)
	
	// spring에서는 redirect는 모두 get방식을 사용한다.
	@RequestMapping(value = "/login", method= {RequestMethod.GET, RequestMethod.POST})				// 로그인 페이지
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		// @RequestParam을 통해 매개변수의 값들을 입력받아 error 및 logout의 매개변수에 입력한다.(required=false는 매개변수가 없어도 무관하다는 것을 의미한다.)
		// 위의 처리를 하는 이유는 컨트롤러에 도착하기 전 filter를 거쳐서 도착하기에 filter가 입력해준 데이터 값을 통해 검증된 접근만 통과시킬 수 있다

		ModelAndView mv = new ModelAndView("user.login");
		String tmploginMsg = (String) request.getAttribute("loginFailMsg");
		
		if(tmploginMsg == null)
			mv.addObject("loginFailMsg", "");
		else
			mv.addObject("loginFailMsg", tmploginMsg);
		// GET 방식으로 들어온 에러 메세지가 없다면, 빈 문자열을 보내고
		// POST 방식으로 들어온 에러 메세지가 있다면, 해당 에러 메시지를 페이지에 전송한다.
		
		return mv;
	}
}
