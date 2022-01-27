package webshopprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller							// ���� Ŭ������ ��Ʈ�ѷ� ����� �Ѵٴ� ���� �Ͻ�(Component�� ����
@RequestMapping("/")				// ���� dispatcher�� ��������־�� �� ����� @ReqeustMapping ������̼ǰ� xml���� component-scan�� ��������ν� �ڵ带 �����ų �� �ִ�.
public class FrontController {
	
	@RequestMapping("main")
//	@ResponseBody
	public String main() {
		return "main";
	}
	
}