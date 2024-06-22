package com.Packages.dao;

import com.Packages.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public User findByUsername(String usrname);
	
	public User findByUsernameAndPassword(String username, String password);
}
