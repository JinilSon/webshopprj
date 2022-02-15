package webshopprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webshopprj.entity.Product;
import webshopprj.service.ProdService;
import webshopprj.service.TestService;
import webshopprj.service.UserService;

@Controller									// ���� Ŭ������ ��Ʈ�ѷ� ����� �Ѵٴ� ���� �Ͻ�(Component�� ����
@RequestMapping("/")						// ���� dispatcher�� ��������־�� �� ����� @ReqeustMapping ������̼ǰ� xml���� component-scan�� ��������ν� �ڵ带 �����ų �� �ִ�.
public class HomeController {
	
//	@Autowired
//	private ProdDao dao;					// Service ������ ���ļ� ����ؾ� �Ѵ�.
	
	@Autowired
	private ProdService p_service;
	
	
	@RequestMapping("main")
	@ResponseBody
	public ModelAndView main() {			// ���� Ȩ������
//		Model : map�����̴�. key, value�� ����Ǹ� 
//		model.addAttribute("������", ��)���� �����Ѵ�.
//		url�� �������� �ʴ��� requstMapping���� ���� url�� jsp�� �̸��� ������ �ڵ����� ��������ش�.
//		������, ã�Ƽ� �����ִ� �����̱⿡ return�� �ϴ� ���� �ƴϹǷ� model�� ���� ��� ������ ���� ����.
		
		List<Product> prodList = p_service.getAllProdDB();
		
		ModelAndView mv = new ModelAndView("root.main");	// ModelAndView�� �ϳ��� �Ű������� ���� �����ڴ� ������ ���ÿ� ViewName�� �����Ѵ�.
		mv.addObject("prodList", prodList);					// mv�� ���� ��ü�� �̸��� ���´�.

		return mv;
	}
	
	
	
}
