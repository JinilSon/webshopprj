package webshopprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import webshopprj.entity.Product;
import webshopprj.entity.User;
import webshopprj.service.AdminService;


@Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;			// 관리자 서비스(DAO 연결)
	
	@RequestMapping("manage")
	public ModelAndView manage() {			// DB 관리 페이지
		
		
		List<Product> prodList = adminService.getAllProdDB();
		List<User> userList = adminService.getAllUserDB();
		ModelAndView mv = new ModelAndView("admin.manage");
		mv.addObject("prodList", prodList);
		mv.addObject("userList", userList);
		
		return mv;
	}

}
