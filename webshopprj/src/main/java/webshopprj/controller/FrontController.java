package webshopprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller							// 현재 클래스가 컨트롤러 기능을 한다는 것을 암시(Component의 역할
@RequestMapping("/")				// 본래 dispatcher가 연결시켜주어야 할 빈들을 @ReqeustMapping 어노테이션과 xml에서 component-scan을 사용함으로써 코드를 단축시킬 수 있다.
public class FrontController {
	
//	@RequestMapping("main")
////	@ResponseBody
//	public String main() {
//		return "main";
//	}
	
	@RequestMapping("main")
//	@ResponseBody
	public String main() {
		
		return "main";
	}
	
}
