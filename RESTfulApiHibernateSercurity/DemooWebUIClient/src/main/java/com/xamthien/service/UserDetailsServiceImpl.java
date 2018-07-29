package com.xamthien.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.xamthien.model.AppUser;
import com.xamthien.model.ReservationStatus;
import com.xamthien.utils.EncrytedPasswordUtils;
import com.xamthien.utils.ParseJsonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service

public class UserDetailsServiceImpl implements UserDetailsService {
	private final String domain = "http://192.168.11.105:8090";
	//private final String domain = "http://192.188.88.119:8090";
//	@Autowired
//    private UserDAO appUserDAO;
//    
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		 AppUser appUser = null;
		try {
			appUser = new UserDetailsServiceImpl().getUserByName(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if (appUser == null) {
	            System.out.println("User not found! " + name);
	            throw new UsernameNotFoundException("User " + name + " was not found in the database");
	        }
	 
	        System.out.println("Found User: " + appUser.getUsername() + " - "+ appUser.getPass());
	 
	        // [USER, ADMIN,..]
	        
	 
	        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
	        GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRole().getRName());
	        System.out.println(appUser.getRole().getRName());
            grantList.add(authority);
	        
	        UserDetails userDetails = (UserDetails) new User(appUser.getUsername(),EncrytedPasswordUtils.encrytePassword(appUser.getPass()), grantList);
	        System.out.println(userDetails.getPassword());
	 
	        return userDetails;
	    }
	
	public AppUser getUserByName(String name) throws IOException
    {
		String Jsonpath = domain+"/api/user/"+name;
		AppUser us = new AppUser();
        us = (AppUser) new ParseJsonUtils().get(Jsonpath, us);
        return us;
    }




}
