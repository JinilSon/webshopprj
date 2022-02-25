package webshopprj.dto;

import java.util.List;

public class ProductDTO {
	private String title;
	private String category;
	private int price;
	private List<String> img;
	private List<String> size;
	private List<Integer> count;
	private List<String> color;
	private String description;
	// img url�� size, count, color�� �迭�� �������ν� �� ���� �޴´�.
	
	public ProductDTO(String title, String category, int price, List<String> img, List<String> size,
			List<Integer> count, List<String> color, String description) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.img = img;
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

	public List<String> getImg() {
		return img;
	}

	public void setImg(List<String> img) {
		this.img = img;
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
