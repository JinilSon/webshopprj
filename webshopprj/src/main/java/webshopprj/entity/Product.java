package webshopprj.entity;

import java.util.Date;

public class Product {
	
	private int id;			// 제품 num
	private String title;	// 제품명
	private String category; // 카테고리
	private int price;		// 가격
	private int discount;	// 할인률
	private String picture;	// 제품사진 url
	private String discription; // 제품설명
	private Date up_Date;	// 등록일자
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
//		this.id = id;
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
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
//		this.up_Date = up_Date;
	}
	

}
