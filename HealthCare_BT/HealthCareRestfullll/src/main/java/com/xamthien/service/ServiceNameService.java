package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;
@Service
@Transactional


public class ServiceNameService {
	@Autowired
	private SeviceNameDAO serviceNameDAO;

	
	public List<Services> getAll() {
        return serviceNameDAO.getAll();
    }

    public Services getserviceByName(String name) {
        return serviceNameDAO.getServicesByName(name);
   }

    public void insert(Services sp) {
        this.serviceNameDAO.insert(sp);
    }

    
    public void update(Services sp) {
        this.serviceNameDAO.update(sp);
    }
    public void delete(Services sp) {
        this.serviceNameDAO.delete(sp);
    }
}
