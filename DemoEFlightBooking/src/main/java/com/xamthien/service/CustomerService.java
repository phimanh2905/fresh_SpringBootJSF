package com.xamthien.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xamthien.DAO.*;
import com.xamthien.model.*;
@Service
@Transactional


public class CustomerService {
	@Autowired
	private CustomerDAO CustomerDAO;

	
	public List<Customer> getAllCustomer() {
        return CustomerDAO.getAllCustomer();
    }

    public Customer geCustomerByID(int id) {
         return CustomerDAO.getCustomerByID(id);
    }

    public void insertCustomer(Customer sp) {
        this.CustomerDAO.insertCustomer(sp);
    }

    
    public void updateCustomer(Customer sp) {
        this.CustomerDAO.updateCustomer(sp);
    }
    public void deleteCustomer(Customer sp) {
        this.CustomerDAO.deleteCustomer(sp);
    }
}
