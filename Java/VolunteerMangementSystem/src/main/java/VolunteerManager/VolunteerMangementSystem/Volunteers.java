package VolunteerManager.VolunteerMangementSystem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="volunteers")
public class Volunteers {
	@Id
	int volunteerid;
	String volunteername;
	int age;
	String qualification;
	String email;
	String address;
	String review;
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
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
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	Long mobileno;
	public Volunteers(int volunteerid, String volunteername, int age, String qualification, String email,
			String address, Long mobileno,String review) {
		super();
		this.volunteerid = volunteerid;
		this.volunteername = volunteername;
		this.age = age;
		this.qualification = qualification;
		this.email = email;
		this.address = address;
		this.mobileno = mobileno;
		this.review=review;
		}	
	public Volunteers() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
