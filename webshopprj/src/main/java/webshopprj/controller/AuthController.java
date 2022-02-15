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
	//Log4J�� ���� ��������� ���� ���Ұ�(�� ���� ����� �߰�)
	
	// spring������ redirect�� ��� get����� ����Ѵ�.
	@RequestMapping(value = "/login", method= {RequestMethod.GET, RequestMethod.POST})				// �α��� ������
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		// @RequestParam�� ���� �Ű������� ������ �Է¹޾� error �� logout�� �Ű������� �Է��Ѵ�.(required=false�� �Ű������� ��� �����ϴٴ� ���� �ǹ��Ѵ�.)
		// ���� ó���� �ϴ� ������ ��Ʈ�ѷ��� �����ϱ� �� filter�� ���ļ� �����ϱ⿡ filter�� �Է����� ������ ���� ���� ������ ���ٸ� �����ų �� �ִ�

		ModelAndView mv = new ModelAndView("user.login");
		String tmploginMsg = (String) request.getAttribute("loginFailMsg");
		
		if(tmploginMsg == null)
			mv.addObject("loginFailMsg", "");
		else
			mv.addObject("loginFailMsg", tmploginMsg);
		// GET ������� ���� ���� �޼����� ���ٸ�, �� ���ڿ��� ������
		// POST ������� ���� ���� �޼����� �ִٸ�, �ش� ���� �޽����� �������� �����Ѵ�.
		
		return mv;
	}
}
