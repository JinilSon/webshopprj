package webshopprj.entity;

public class User {
	
	private String id;
	private String pw;
	private String name;
	private String birthdate;
	private String phonenum;
	private String email;
	private String authList;
	private String b_item_num;		// {������ ǰ���� id, ����}
	private int t_pay;				// total pay, �̹� �� �� �����ݾ�
	private int c_point;			// current point
	
	
	
	public User(String id, String pw, String name, String birthdate, String phonenum, String email, String authList) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthdate = birthdate;
		this.phonenum = phonenum;
		this.email = email;
		this.authList = authList;
	}
	// ���ε�� ������
	
	public User(String id, String pw, String name, String birthdate, String phonenum, String email, String authList, String b_item_num,
			int t_pay, int c_point) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthdate = birthdate;
		this.phonenum = phonenum;
		this.email = email;
		this.b_item_num = b_item_num;
		this.t_pay = t_pay;
		this.c_point = c_point;
		this.authList = authList;
	}
	// �ٿ�ε�� ������
	
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
	public String getAuthList() {
		return authList;
	}
	public void setAuthList(String authList) {
		this.authList = authList;
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
