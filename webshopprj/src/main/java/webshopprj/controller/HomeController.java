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

@Controller									// 현재 클래스가 컨트롤러 기능을 한다는 것을 암시(Component의 역할
@RequestMapping("/")						// 본래 dispatcher가 연결시켜주어야 할 빈들을 @ReqeustMapping 어노테이션과 xml에서 component-scan을 사용함으로써 코드를 단축시킬 수 있다.
public class HomeController {
	
//	@Autowired
//	private ProdDao dao;					// Service 계층을 거쳐서 사용해야 한다.
	
	@Autowired
	private ProdService p_service;
	
	
	@RequestMapping("main")
	@ResponseBody
	public ModelAndView main() {			// 메인 홈페이지
//		Model : map구조이다. key, value로 저장되며 
//		model.addAttribute("변수명", 값)으로 저장한다.
//		url을 리턴하지 않더라도 requstMapping으로 받은 url과 jsp의 이름이 같으면 자동으로 연결시켜준다.
//		하지만, 찾아서 보여주는 구조이기에 return을 하는 것은 아니므로 model에 값을 담아 전달할 수는 없다.
		
		List<Product> prodList = p_service.getAllProdDB();
		
		ModelAndView mv = new ModelAndView("root.main");	// ModelAndView의 하나의 매개변수를 가진 생성자는 생성과 동시에 ViewName을 설정한다.
		mv.addObject("prodList", prodList);					// mv에 담을 객체와 이름을 적는다.

		return mv;
	}
	
	
	
}
