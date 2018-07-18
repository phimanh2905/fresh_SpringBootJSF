package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;

@Service
@Transactional
public class AppRoleService {
	@Autowired
	private AppRoleDAO appRoleDAO;
	
	public List<AppRole> getAllSach() {
        return appRoleDAO.getAllAppRole();
    }

    public AppRole getSachByID(long id) {
         return appRoleDAO.getRoleByID(id);
    }

    public void insertAppRole(AppRole sp) {
        this.appRoleDAO.insertAppRole(sp);
    }

    
    public void updateAppRole(AppRole sp) {
        this.appRoleDAO.updateAppRole(sp);
    }
    public void deleteAppRole(AppRole sp) {
        this.appRoleDAO.deleteAppRole(sp);
    }
   

}
