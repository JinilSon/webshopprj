package webshopprj.entity;

public class User {
	
	private String id;
	private String pw;
	private String name;
	private String birthdate;
	private String phonenum;
	private String email;
	private String b_item_num;		// {구매한 품목의 id, 수량}
	private int t_pay;				// total pay, 이번 달 총 결제금액
	private int c_point;			// current point
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getB_item_num() {
		return b_item_num;
	}
	public void setB_item_num(String b_item_num) {
		this.b_item_num = b_item_num;
	}
	public int getT_pay() {
		return t_pay;
	}
	public void setT_pay(int t_pay) {
		this.t_pay = t_pay;
	}
	public int getC_point() {
		return c_point;
	}
	public void setC_point(int c_point) {
		this.c_point = c_point;
	}

}
