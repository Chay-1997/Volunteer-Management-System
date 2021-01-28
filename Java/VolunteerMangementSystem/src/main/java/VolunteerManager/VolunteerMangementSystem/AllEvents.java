package VolunteerManager.VolunteerMangementSystem;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;






@Component
@Entity
@Table(name="allevents")
public class AllEvents {

	@Id
	int eventid;
	@Column(name="event_name")
	public
	String eventName;
	public String address;
	String city;
	Date date_of_event;
	String time;
	int no_of_volunteers_required;
	public AllEvents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllEvents(int eventid, String event_name, String address, String city, Date date_of_event, String time,
			int no_of_volunteers_required) {
		super();
		this.eventid = eventid;
		this.eventName = event_name;
		this.address = address;
		this.city = city;
		this.date_of_event = date_of_event;
		this.time = time;
		this.no_of_volunteers_required = no_of_volunteers_required;
	}
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEvent_name() {
		return eventName;
	}
	public void setEvent_name(String event_name) {
		this.eventName = event_name;
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
	
	
	
	
}
