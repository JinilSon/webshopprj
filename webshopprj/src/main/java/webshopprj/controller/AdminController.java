package webshopprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@RequestMapping("management")
	public ModelAndView management() {			// DB 관리 페이지
		
		ModelAndView mv = new ModelAndView("admin.management");
		
		return mv;
	}

}
