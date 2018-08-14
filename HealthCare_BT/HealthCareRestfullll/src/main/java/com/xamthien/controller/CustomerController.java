package com.xamthien.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xamthien.model.*;
import com.xamthien.service.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CustomerController {
	
	
		@Autowired
	    private ServiceNameService serviceNameService;
		
	    @RequestMapping(value = "/api/services",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public List<Services> getAll() {
	        List<Services> list = serviceNameService.getAll();
	        return list;
	    }
	    
	    @RequestMapping(value = "/api/service/{phone}",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE}) 
	    @ResponseBody
	    public Services getServiceByName(@PathVariable("name") String name) {
	    	Services pm = serviceNameService.getserviceByName(name);
	        return pm;
	    }
	 


}
