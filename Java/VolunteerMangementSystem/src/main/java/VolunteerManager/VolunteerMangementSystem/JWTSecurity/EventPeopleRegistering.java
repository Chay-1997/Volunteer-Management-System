package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

public class EventPeopleRegistering {
	
	private String hostname;
	private String email;
	public EventPeopleRegistering() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String password;
	public EventPeopleRegistering(String hostname, String email, String password) {
		super();
		this.hostname = hostname;
		this.email = email;
		this.password = password;
		
	}
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
