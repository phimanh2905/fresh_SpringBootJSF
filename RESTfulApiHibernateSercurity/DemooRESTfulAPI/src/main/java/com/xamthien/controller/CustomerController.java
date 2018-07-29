package com.xamthien.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.DAO.EmployeeDAO;
import com.xamthien.model.*;
import com.xamthien.service.*;



@RestController
public class CustomerController {
	
	
		@Autowired
	    private CustomerService customerService;
		
		@Autowired
	    private EmployeeDAO employeeDAO;
	  
	    @RequestMapping(value = "/api/customers",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public List<Customer> getAll() {
	        List<Customer> list = customerService.getAllCustomer();
	        return list;
	    }
	    
	    @RequestMapping(value = "/api/customer/{phone}",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public Customer getCustomerByPhone(@PathVariable("phone") String phone) {
	    	Customer pm = customerService.geCustomerByPhone(phone);
	        return pm;
	    }
	 
	    @RequestMapping(value = "/api/customer",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public void addNew(@Valid @RequestBody String json,HttpServletResponse response) throws IOException {
	    	response.setCharacterEncoding("utf-8");
	    	ObjectMapper mapper = new ObjectMapper();
	    	Customer cus = mapper.readValue(json, Customer.class);
	    	customerService.insertCustomer(cus);
	        response.getWriter().println("Thêm khách hàng thành công"); 
	    	//return cus;
	    }
	    
	    @RequestMapping(value = "/api/customer",method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public void update(@Valid @RequestBody String json ,HttpServletResponse response) throws IOException {
	    	response.setCharacterEncoding("utf-8");
	    	ObjectMapper mapper = new ObjectMapper();
	    	Customer cus = mapper.readValue(json, Customer.class);
	    	customerService.updateCustomer(cus);
	        response.getWriter().println("Sửa khách hàng thành công"); 
	    	//return cus;
	    }

}
