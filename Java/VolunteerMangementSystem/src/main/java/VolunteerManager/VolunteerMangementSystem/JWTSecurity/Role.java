package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERoles name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERoles getName() {
		return name;
	}

	public void setName(ERoles name) {
		this.name = name;
	}

	public Role(ERoles name) {
		super();
		this.name = name;
	}

	public Role() {
		super();
	}
	
	
	
	

}
