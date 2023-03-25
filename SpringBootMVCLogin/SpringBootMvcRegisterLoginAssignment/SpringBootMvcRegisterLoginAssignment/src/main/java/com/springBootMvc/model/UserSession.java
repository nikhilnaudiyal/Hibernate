package com.springBootMvc.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserSession {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String eventType;



@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
private Timestamp timestamp=new Timestamp(System.currentTimeMillis());

//
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="user_id")
private User user;

public UserSession() {
	
}
public UserSession(String eventType) {
	this.eventType = eventType;
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getEventType() {
	return eventType;
}
public void setEventType(String eventType) {
	this.eventType = eventType;
}
public Timestamp getTimestamp() {
	return timestamp;
}
//@Override
//public String toString() {
//	return "UserSession [id=" + id + ", eventType=" + eventType + ", timestamp=" + timestamp + "]";
//}
@Override
public String toString() {
	return "UserSession [id=" + id + ", eventType=" + eventType + ", timestamp=" + timestamp + ", user=" + user + "]";
}
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}







}
