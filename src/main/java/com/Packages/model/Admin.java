package com.Packages.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_tbl")
public class Admin {
	
	@Id
	private int admid;
	private String adminusername;
	private String adminemail;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public int getAdmid() {
		return admid;
	}

	public void setAdmid(int admid) {
		this.admid = admid;
	}

	public String getAdminusername() {
		return adminusername;
	}

	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}

	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(int admid, String adminusername, String adminemail, String password) {
		super();
		this.admid = admid;
		this.adminusername = adminusername;
		this.adminemail = adminemail;
		this.password = password;
	}
	
}
