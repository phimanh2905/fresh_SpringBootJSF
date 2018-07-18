package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;

@Service
@Transactional
public class AppUserService {
	@Autowired
	private AppUserDAO appUserDAO;
	
	public List<AppUser> getAllSach() {
        return appUserDAO.getAllAppUser();
    }

    public AppUser getAppUserByID(String name) {
         return appUserDAO.getUserByName(name);
    }

    public void insertAppRole(AppUser sp) {
        this.appUserDAO.insertAppUser(sp);
    }

    
    public void updateAppRole(AppUser sp) {
        this.appUserDAO.updateAppUser(sp);
    }
    public void deleteAppRole(AppUser sp) {
        this.appUserDAO.deleteAppUser(sp);
    }
}
