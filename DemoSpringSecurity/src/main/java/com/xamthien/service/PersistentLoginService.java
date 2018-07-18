package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;
@Service
@Transactional
public class PersistentLoginService {
	@Autowired
	private PersistentLoginDAO persistentLoginDAO;
	
	public List<PersistentLogins> getAll() {
        return persistentLoginDAO.getAllPersistentLogins();
    }

//    public PersistentLogins getAppUserByID(long id) {
//         return persistentLoginDAO.get;
//    }

    public void insertPersistentLogins(PersistentLogins sp) {
        this.persistentLoginDAO.insertPersistentLogins(sp);;
    }

    
    public void updatePersistentLogins(PersistentLogins sp) {
        this.persistentLoginDAO.updatePersistentLogins(sp);;
    }
    public void deletePersistentLogins(PersistentLogins sp) {
        this.persistentLoginDAO.deletePersistentLogins(sp);;
    }
}
