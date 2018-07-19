package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;
@Service
@Transactional


public class UserRoleService {
	@Autowired
	private UserRoleDAO userRoleDAO;
	@Autowired
	private AppUserDAO appUserDAO;
	@Autowired
	private AppRoleDAO appRoleDAO;
	
	public List<UserRole> getAllUserRole() {
        return userRoleDAO.getAllUserRole();
    }

    public UserRole getAppUserByID(long id) {
         return userRoleDAO.getUserRoleByID(id);
    }

    public void insertAppRole(UserRole sp) {
        this.userRoleDAO.insertUserRole(sp);
    }

    
    public void updateAppRole(UserRole sp) {
        this.userRoleDAO.updateUserRole(sp);
    }
    public void deleteAppRole(UserRole sp) {
        this.userRoleDAO.deleteUserRole(sp);
    }
}
