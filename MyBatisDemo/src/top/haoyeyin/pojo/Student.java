package top.haoyeyin.pojo;

public class Student {

	private int id;
	private String loginname;
	private String loginpass;
	private String name;
	private String sex;
	
	public Student(){
		
	}
	public Student(String loginname, String loginpass, String name,
			String sex) {
		super();
		
		this.loginname = loginname;
		this.loginpass = loginpass;
		this.name = name;
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", loginname=" + loginname
				+ ", loginpass=" + loginpass + ", name=" + name + ", sex="
				+ sex + "]";
	}
	
	
}
