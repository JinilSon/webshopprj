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

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	// 로그를 남기기 위한 변수(slf4j)
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)				// 로그인 페이지
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		// @RequestParam을 통해 매개변수의 값들을 입력받아 error 및 logout의 매개변수에 입력한다.(required=false는 매개변수가 없어도 무관하다는 것을 의미한다.)
		// 위의 처리를 하는 이유는 컨트롤러에 도착하기 전 filter를 거쳐서 도착하기에 filter가 입력해준 데이터 값을 통해 검증된 접근만 통과시킬 수 있다
		ModelAndView mv = new ModelAndView("user.login");
		
		System.out.println(request);
		
		
		return mv;
	}
}
