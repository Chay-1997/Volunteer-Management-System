package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="users",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "username")
})

public class User {
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	private String email;
	
	private String password;
	
	@ManyToMany(fetch =FetchType.LAZY)
	@JoinTable(name = "user_roles",
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns =@JoinColumn(name="role_id"))
	private Set<Role>roles=new HashSet<Role>();

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	

	


	
	
	
	

}
