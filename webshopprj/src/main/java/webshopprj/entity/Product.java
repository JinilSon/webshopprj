package webshopprj.entity;

import java.util.Date;

public class Product {
	
	private int id;			// 제품 num
	private String title;	// 제품명
	private String category; // 카테고리
	private int price;		// 가격
	private String size;	// 사이즈
	private String color;	// 색상
	private int count;		// 개수
	private String img;	// 제품사진 url
	private String discription; // 제품설명
	private Date up_Date;	// 등록일자(자동생성)
	
	public Product(int id, String title, String category, int price, String size, String color, int count,
			String img, String discription, Date up_Date) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.size = size;
		this.color = color;
		this.count = count;
		this.img = img;
		this.discription = discription;
		this.up_Date = up_Date;
	}
	// 다운로드용
	
	public Product(String title, String category, int price, String size, String color, int count,
			String img, String discription) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.size = size;
		this.color = color;
		this.count = count;
		this.img = img;
		this.discription = discription;
	}
	// 업로드용
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String picture) {
		this.img = picture;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Date getUp_Date() {
		return up_Date;
	}
	public void setUp_Date(Date up_Date) {
		this.up_Date = up_Date;
	}
	
	
}
