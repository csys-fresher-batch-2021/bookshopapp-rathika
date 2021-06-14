package in.rathika.model;

public class User {

	/**
	 * Declaring required variables.
	 */
	private int id;
	private String name;

	private String email;
	private Long mobile;
	private String address;
	private int age;
	private String password;
	private String confrimPassword;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Long getMobile() {
		return mobile;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public String getPassword() {
		return password;
	}

	public String getConfrimPassword() {
		return confrimPassword;
	}
	public int getId() {
		return id;
	}

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

	public User(int id,String emailId, long mobile2, String address2) {
		this.id = id;
		this.email = emailId;
		this.mobile = mobile2;
		this.address = address2;
	}

	/*
	 * public User(String adminname, String pass) { this.name = adminname;
	 * this.password = pass; }
	 */

	public User(int userId, String name2) {
		this.id = userId;
		this.name = name2;
		
	}

	public User(String email, String password) {
	
		this.email = email;
		this.password = password;
	}
   
}
