package com.Packages.service;

import com.Packages.model.User;

public interface UserService {

	public String registerUser(User usr);
	
	public String userLogin(String username, String password);
}
