package com.Packages.service;

import javax.transaction.Transactional;

import com.Packages.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Packages.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public String registerUser(User usr) {
		User usrr =  userDao.save(usr);
		return "User Added Successfully";
		
	}

	@Override
	public String userLogin(String username, String password) {
		User found = userDao.findByUsername(username);
		if(found == null) {
			return "User Dosn't Exist";
		}
		else {
			found = userDao.findByUsernameAndPassword(username, password);
			if(found == null) {
				return "Wrong Password";
			}
			else {
				return "Login Success";
			}
		}
	}

}
