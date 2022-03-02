package webshopprj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import webshopprj.dto.ProductDTO;
import webshopprj.entity.Product;
import webshopprj.entity.User;
import webshopprj.service.AdminService;


@Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;			// ������ ����(DAO ����)
	
	@RequestMapping("manage")
	public ModelAndView manage() {			// DB ���� ������
		
		List<Product> prodList = adminService.getAllProdDB();
		List<User> userList = adminService.getAllUserDB();
		ModelAndView mv = new ModelAndView("admin.manage");
		mv.addObject("prodList", prodList);
		mv.addObject("userList", userList);
		
		return mv;
	}
	
	@PostMapping("manage/add")
	public String add(String title, String category, int price, 
			@RequestParam(value = "color") List<String> color,
			@RequestParam(value = "size") List<String> size,
			@RequestParam(value = "count") List<String> count,
			String description, List<MultipartFile> img_data) {
			// List������ �Ű�����ȭ�� @RequestParam���� ���� �������־���Ѵ�.(�׷��� ���� ��� List�� ã�� ���Ѵٰ� ������ �߻���)
	
		
		System.out.println("title : " + title);
		System.out.println("category : " + category);
		System.out.println("price : " + price);
		System.out.println("description : " + description);
		System.out.println("color : " + color.toString());
		System.out.println("size : " + size.toString());
		System.out.println("count : " + count.toString());
		for(int i=0; i < img_data.size(); i++)
			System.out.println("img_data : " + img_data.get(i).getOriginalFilename());
		
		//ProductDTO pdto = new ProductDTO(title, category, price, img_data, size, count, color, description)
		return "redirect:/manage";
	}

}
