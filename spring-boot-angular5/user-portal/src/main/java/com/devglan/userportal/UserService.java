package com.devglan.userportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserDAO userDAO;

    
    public void create(User user) {
        this.userDAO.create(user);
    }

    
    public void delete(int id) {
        User user = findById(id);
        if(user != null){
        	userDAO.delete(user);
        }
        
    }

    
    public List<User> findAll() {
        return userDAO.findAll();
    }

    
    public User findById(int id) {
        return userDAO.findById(id);
    }

    
    public void update(User user) {
        this.userDAO.update(user);
    }
}
