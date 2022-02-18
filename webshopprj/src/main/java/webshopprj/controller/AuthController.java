package webshopprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
	//Log4J�� ���� ��������� ���� ���Ұ�(�� ���� ����� �߰�)
	
	// spring������ redirect�� ��� get����� ����Ѵ�.
	@RequestMapping(value = "/login", method= RequestMethod.GET)				// �α��� ������
	public String loginGet(HttpServletRequest request) {
		// @RequestParam�� ���� �Ű������� ������ �Է¹޾� error �� logout�� �Ű������� �Է��Ѵ�.(required=false�� �Ű������� ��� �����ϴٴ� ���� �ǹ��Ѵ�.)
		// ���� ó���� �ϴ� ������ ��Ʈ�ѷ��� �����ϱ� �� filter�� ���ļ� �����ϱ⿡ filter�� �Է����� ������ ���� ���� ������ ���ٸ� �����ų �� �ִ�

		String prevUrl = (String)request.getHeader("REFERER");
		// ���� �������� url �� request��ü���� �����Ѵ�.(security�� ���鼭�� ���� �������� url�� ���� �� �ִ�.)
		// ���ǻ���! : ��ũ�� Ŭ���ؼ� ���� ��츸 �� �� �ְ�, URL�� ���� ġ�� ������ ���� null�̴�.
		request.getSession().setAttribute("prevPage", prevUrl);
		
		
		return "user.login";
	}
	
	
	
	// POST ��� ��������, security�� ���ļ� ���� ����� ������ ���(ex)�α��� ���з�, �����̷�Ʈ)
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
		System.out.println("�α׾ƿ���");
	}
	
}
