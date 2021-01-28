package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import java.sql.Date;

public class EventAddingWithTokenIs {


	private String event_name;
	private String address;
	private String city;
	private Date date_of_event;
	public EventAddingWithTokenIs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventAddingWithTokenIs(String event_name, String address, String city, Date date_of_event, String time,
			int no_of_volunteers_required, int tokenid) {
		super();
		this.event_name = event_name;
		this.address = address;
		this.city = city;
		this.date_of_event = date_of_event;
		this.time = time;
		this.no_of_volunteers_required = no_of_volunteers_required;
		this.tokenid = tokenid;
	}
	private String time;
	private int no_of_volunteers_required;
	private int tokenid;
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDate_of_event() {
		return date_of_event;
	}
	public void setDate_of_event(Date date_of_event) {
		this.date_of_event = date_of_event;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getNo_of_volunteers_required() {
		return no_of_volunteers_required;
	}
	public void setNo_of_volunteers_required(int no_of_volunteers_required) {
		this.no_of_volunteers_required = no_of_volunteers_required;
	}
	public int getTokenid() {
		return tokenid;
	}
	public void setTokenid(int tokenid) {
		this.tokenid = tokenid;
	}
	
	
	
	
	
}
