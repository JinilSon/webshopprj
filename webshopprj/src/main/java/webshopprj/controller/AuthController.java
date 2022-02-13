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
	// �α׸� ����� ���� ����(slf4j)
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)				// �α��� ������
	public ModelAndView login(
		@RequestParam(value="error", required=false) String error,
		@RequestParam(value="logout", required=false) String logout) {
		// @RequestParam�� ���� �Ű������� ������ �Է¹޾� error �� logout�� �Ű������� �Է��Ѵ�.(required=false�� �Ű������� ��� �����ϴٴ� ���� �ǹ��Ѵ�.)
		// ���� ó���� �ϴ� ������ ��Ʈ�ѷ��� �����ϱ� �� filter�� ���ļ� �����ϱ⿡ filter�� �Է����� ������ ���� ���� ������ ���ٸ� �����ų �� �ִ�
		ModelAndView mv = new ModelAndView();
		
		if(error != null) {
			mv.setViewName("error");
			mv.addObject("error", "Invalid username and password!");
			System.out.println("error�� ����");
		}
		else if(logout != null) {
			mv.setViewName("main");
			mv.addObject("msg", "You logged out successfully");
			System.out.println("msg�� ����");
		}
		else {
			mv.setViewName("user.login");
			System.out.println("user.login�� ����");
		}
		
		return mv;
	}
}
