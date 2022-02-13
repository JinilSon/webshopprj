package webshopprj.controller;

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
	public ModelAndView login(
		@RequestParam(value="error", required=false) String error,
		@RequestParam(value="logout", required=false) String logout) {
		// @RequestParam을 통해 매개변수의 값들을 입력받아 error 및 logout의 매개변수에 입력한다.(required=false는 매개변수가 없어도 무관하다는 것을 의미한다.)
		// 위의 처리를 하는 이유는 컨트롤러에 도착하기 전 filter를 거쳐서 도착하기에 filter가 입력해준 데이터 값을 통해 검증된 접근만 통과시킬 수 있다
		ModelAndView mv = new ModelAndView();
		
		if(error != null) {
			mv.setViewName("error");
			mv.addObject("error", "Invalid username and password!");
			System.out.println("error로 접근");
		}
		else if(logout != null) {
			mv.setViewName("main");
			mv.addObject("msg", "You logged out successfully");
			System.out.println("msg로 접근");
		}
		else {
			mv.setViewName("user.login");
			System.out.println("user.login로 접근");
		}
		
		return mv;
	}
}
