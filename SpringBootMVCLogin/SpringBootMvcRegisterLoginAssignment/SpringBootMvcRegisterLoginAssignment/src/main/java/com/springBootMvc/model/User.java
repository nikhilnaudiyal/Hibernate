package com.springBootMvc.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name="client_id")
	private String clientId;
	private String firstname;
	private String lastname;
	
	private String username;
	private String password;
	
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name="user_id",referencedColumnName = "id")
	
	@OneToMany(cascade = CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy = "user")
	private Set<UserSession> userSession=new HashSet<>();
	
	
	
	public User() {
	
	}
	
	public User(String clientId,String firstname, String lastname, String username, String password)
			 {
	
		
		this.clientId=clientId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<UserSession> getUserSession() {
		return userSession;
	}
	public void setUserSession(Set<UserSession> userSession) {
		this.userSession = userSession;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", clientId=" + clientId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", password=" + password + ", userSession=" + userSession + "]";
	}
	
	
	
	
}
