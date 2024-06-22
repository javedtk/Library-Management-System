package com.Packages.dao;

import com.Packages.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{
	
	public Admin findByAdminusername(String adminusername);
	
	public Admin findByAdminusernameAndPassword(String adminusername, String password);
}
