package webshopprj.vo;

public class UserVO {
// User�� ���� ����(id, pw ����)�� ���� ��ü�̴�.
	
	private String id;
	private String pw;
	
	
	public UserVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
}