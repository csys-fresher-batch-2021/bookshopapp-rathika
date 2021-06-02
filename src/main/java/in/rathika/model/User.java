package in.rathika.model;

public class User {
    private String name;
    private String email;
    private Long mobile;
    private String address;
    private int age;
    private String password;
    private String confrimPassword;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfrimPassword() {
		return confrimPassword;
	}
	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

    
	
	

	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", age="
				+ age + ", password=" + password + "]";
	}
	public User(String name2, String email2, Long mobile2, String address2, int age2, String password2) {
		this.name = name2;
		this.email = email2;
		this.mobile = mobile2;
		this.address = address2;
		this.age = age2;
		this.password = password2;
	
	}
	
    
}
