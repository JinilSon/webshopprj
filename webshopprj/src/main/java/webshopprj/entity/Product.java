package webshopprj.entity;

import java.util.Date;

public class Product {
	
	private int id;			// ��ǰ num
	private String title;	// ��ǰ��
	private String category; // ī�װ�
	private int price;		// ����
	private int discount;	// ���η�
	private String picture;	// ��ǰ���� url
	private String discription; // ��ǰ����
	private Date up_Date;	// �������
	
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
