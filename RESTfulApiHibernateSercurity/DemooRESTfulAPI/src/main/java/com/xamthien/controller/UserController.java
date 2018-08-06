package com.xamthien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xamthien.model.*;
import com.xamthien.service.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/api/user/{name}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})     
    @ResponseBody
    public AppUser getByID(@PathVariable("name") String name) {
		AppUser us = userService.geUserByName(name);
        return us;
    }
}
