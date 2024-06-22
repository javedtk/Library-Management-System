package com.Packages.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Packages.dao.AdminDao;
import com.Packages.model.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String adminRegister(Admin adm) {
		Admin admm = adminDao.save(adm);
		return "Admin Added Successfully";
	}

	@Override
	public String adminLogin(String adminusername, String password) {
		Admin found = adminDao.findByAdminusername(adminusername);
		if(found == null) {
			return "User Dosn't Exist";
		}
		else {
			found = adminDao.findByAdminusernameAndPassword(adminusername, password);
		if(found == null) {
			return "Wrong Password";
		}
		else {
			return "Login Success";
			}
		}
	}

}
