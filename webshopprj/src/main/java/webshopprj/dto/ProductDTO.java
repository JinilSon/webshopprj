package webshopprj.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private String title;
	private String category;
	private int price;
	private List<MultipartFile> img_data;
	private List<String> size;
	private List<Integer> count;
	private List<String> color;
	private String description;
	// img url과 size, count, color는 배열로 받음으로써 한 번에 받는다.
	
	public ProductDTO(String title, String category, int price, List<MultipartFile> img_data, List<String> size,
			List<Integer> count, List<String> color, String description) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.img_data = img_data;
		this.size = size;
		this.count = count;
		this.color = color;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<MultipartFile> getImg_data() {
		return img_data;
	}
	public void setImg_data(List<MultipartFile> img_data) {
		this.img_data = img_data;
	}
	public List<String> getSize() {
		return size;
	}
	public void setSize(List<String> size) {
		this.size = size;
	}
	public List<Integer> getCount() {
		return count;
	}
	public void setCount(List<Integer> count) {
		this.count = count;
	}
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
