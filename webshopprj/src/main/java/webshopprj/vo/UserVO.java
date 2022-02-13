package webshopprj.vo;

public class UserVO {
// User의 계정 검증(id, pw 검증)을 위한 객체이다.
	
	private String id;
	private String pw;
	
	
	public UserVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	// 다운로드용 생성자
	
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