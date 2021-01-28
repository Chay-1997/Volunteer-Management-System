package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eventguy")
public class GuyEvent {

	@Id
	@Column(name="eid")
	private int eid;
	
	public GuyEvent(int eid, int id, String event) {
		super();
		this.eid = eid;
		this.id = id;
		this.event = event;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}


	@Column(name="id")
	private int id;
	
	public GuyEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public GuyEvent(int id, String event) {
//		super();
//		this.id = id;
//		this.event = event;
//	}

	
	@Column(name="event")
	private String event;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	
	
	

}
