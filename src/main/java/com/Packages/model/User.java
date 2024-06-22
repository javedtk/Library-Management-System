package com.Packages.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usrid;
	private String username;
	private String useremail;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUsrid() {
		return usrid;
	}

	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int usrid, String username, String useremail, String password) {
		super();
		this.usrid = usrid;
		this.username = username;
		this.useremail = useremail;
		this.password = password;
	}
	
	
}
