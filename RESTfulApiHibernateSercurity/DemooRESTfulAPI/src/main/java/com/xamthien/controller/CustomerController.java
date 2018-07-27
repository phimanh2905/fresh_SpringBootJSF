package com.xamthien.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xamthien.model.*;
import com.xamthien.service.*;



@RestController
public class CustomerController {
	
	
		@Autowired
	    private CustomerService customerService;
	 
	  
	    @RequestMapping(value = "/api/customers",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public List<Customer> getAll() {
	        List<Customer> list = customerService.getAllCustomer();
	        return list;
	    }
	    
	    
	 
	    @RequestMapping(value = "/api/customer",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public void addNew(@RequestBody Customer cus,HttpServletResponse response) throws IOException {
	    	response.setCharacterEncoding("utf-8");
	    	customerService.insertCustomer(cus);
	        response.getWriter().println("Thêm khách hàng thành công"); 
	    }
	    
}
