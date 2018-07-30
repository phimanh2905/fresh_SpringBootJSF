package com.xamthien.controller;

import java.io.IOException;

import com.xamthien.model.AppUser;
import com.xamthien.utils.ParseJsonUtils;

public class UserController {
	
	//private final String domain = "http://192.168.11.105:8090";
	private final String domain = "http://192.188.88.119:8090";
	
	public AppUser getUserByName(String name) throws IOException
    {
		String Jsonpath = domain+"/api/user/"+name;
		AppUser us = new AppUser();
        us = (AppUser) new ParseJsonUtils().get(Jsonpath, us);
        return us;
    }
}
