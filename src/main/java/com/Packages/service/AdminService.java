package com.Packages.service;

import com.Packages.model.Admin;

public interface AdminService {

	public String adminRegister(Admin adm);
	
	public String adminLogin(String adminusername, String password);
}
