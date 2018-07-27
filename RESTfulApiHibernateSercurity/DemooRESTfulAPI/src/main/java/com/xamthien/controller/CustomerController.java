package com.xamthien.controller;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.DAO.*;
import com.xamthien.model.*;
import com.xamthien.service.*;



@RestController
public class CustomerController {
	
	
		@Autowired
	    private CustomerService customerService;
	 
	  
	    @RequestMapping(value = "/customers",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public List<Customer> getAll() {
	        List<Customer> list = customerService.getAllCustomer();
	        return list;
	    }
	    
	    
	 
	    @RequestMapping(value = "/customer",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public void addNew(@RequestBody Customer fli,HttpServletResponse response) throws IOException {
	    	response.setCharacterEncoding("utf-8");
	    	customerService.insertCustomer(fli);;
	        response.getWriter().println("Thêm khách hàng thành công"); 
	    }
}
