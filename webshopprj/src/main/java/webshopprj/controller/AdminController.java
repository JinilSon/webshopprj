package webshopprj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	@PostMapping("manage/add")
	public String add(String title, String category, String price, 
			@RequestParam(value = "color") List<String> color,
			@RequestParam(value = "size") List<String> size,
			String description, List<MultipartFile> img_data) {
			// List형식의 다운로드는 @RequestParam으로 직접 지정해주어야한다.(그렇지 않을 경우 List를 찾지 못한다고 에러가 발생함)
		
		System.out.println("title : " + title);
		System.out.println("category : " + category);
		System.out.println("price : " + price);
		System.out.println("description : " + description);
		System.out.println("color : " + color.toString());
		System.out.println("color : " + size.toString());
		for(int i=0; i < img_data.size(); i++)
			System.out.println("img_data : " + img_data.get(i).getOriginalFilename());
		
		return "redirect:/manage";
	}

}
