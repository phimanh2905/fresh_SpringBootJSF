package com.xamthien.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;
@Service
@Transactional

public class UserService {
	@Autowired
	private UserDAO userDAO;

	
	
    public AppUser geUserByName(String name) {
         return userDAO.getUserByName(name);
    }
}
