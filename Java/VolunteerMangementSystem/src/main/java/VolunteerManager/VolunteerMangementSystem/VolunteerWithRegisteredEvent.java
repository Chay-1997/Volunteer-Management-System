package VolunteerManager.VolunteerMangementSystem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="volunteerregistertable")
public class VolunteerWithRegisteredEvent {
	@Id
	int volunteerid;
	public String volunteername;
	int age;
	String qualification;
	String email;
	String address;
	Long mobilenumber;
	public int getVolunteerid() {
		return volunteerid;
	}
	public void setVolunteerid(int volunteerid) {
		this.volunteerid = volunteerid;
	}
	public String getVolunteername() {
		return volunteername;
	}
	public void setVolunteername(String volunteername) {
		this.volunteername = volunteername;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return qualification;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEventnameregistered() {
		return eventnameregistered;
	}
	public void setEventnameregistered(String eventnameregistered) {
		this.eventnameregistered = eventnameregistered;
	}
	public VolunteerWithRegisteredEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	String eventnameregistered;
	public VolunteerWithRegisteredEvent(int volunteerid, String volunteername, int age, String qualification,
			String email, String address, Long mobilenumber, String eventnameregistered) {
		super();
		this.volunteerid = volunteerid;
		this.volunteername = volunteername;
		this.age = age;
		this.qualification = qualification;
		this.email = email;
		this.address = address;
		this.mobilenumber = mobilenumber;
		this.eventnameregistered = eventnameregistered;
	}
	
}
