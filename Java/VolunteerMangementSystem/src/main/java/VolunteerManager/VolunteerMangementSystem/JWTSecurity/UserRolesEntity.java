package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRolesEntity {

	@Id
	@Column(name="user_id")
	private int userid;
	@Column(name="role_id")
	private int roleid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public UserRolesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRolesEntity(int userid, int roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}
	
	
	
	
	
}
