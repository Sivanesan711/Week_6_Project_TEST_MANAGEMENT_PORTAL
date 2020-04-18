package model;

public class Staff {

	private String college_id;
	private String college_name;
	private String username;
	private String password;
	
	public String getCollege_id() {
		return college_id;
	}
	public void setCollege_id(String college_id) {
		this.college_id = college_id;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Staff(String college_id, String college_name, String username, String password) {
		super();
		this.college_id = college_id;
		this.college_name = college_name;
		this.username = username;
		this.password = password;
	}
	
	
	
}
