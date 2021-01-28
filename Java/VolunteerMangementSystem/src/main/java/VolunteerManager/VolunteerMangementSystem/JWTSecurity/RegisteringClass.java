package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

public class RegisteringClass {
	
	private String name;
	private int age;
	private String qualification;
	private String email;
	private Long number;
	private String address;
	private String password;
	
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RegisteringClass(String name, int age, String qualification, String email, Long number, String address,
			String password) {
		super();
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		this.email = email;
		this.number = number;
		this.address = address;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return this.qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
