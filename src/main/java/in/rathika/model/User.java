package in.rathika.model;

public class User {

	/**
	 * Declaring required variables.
	 */
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
