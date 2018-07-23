package com.xamthien.service;
import java.util.ArrayList;
import java.util.List;

import com.xamthien.DAO.UserDAO;
import com.xamthien.model.AppUser;
import com.xamthien.utils.EncrytedPasswordUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
    private UserDAO appUserDAO;
    
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		 AppUser appUser = this.appUserDAO.getUserByName(name);
		 if (appUser == null) {
	            System.out.println("User not found! " + name);
	            throw new UsernameNotFoundException("User " + name + " was not found in the database");
	        }
	 
	        System.out.println("Found User: " + appUser.getUsername() + " - "+ appUser.getPass());
	 
	        // [USER, ADMIN,..]
	        
	 
	        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
	        GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRole().getRName());
            grantList.add(authority);
	        
	        UserDetails userDetails = (UserDetails) new User(appUser.getUsername(),EncrytedPasswordUtils.encrytePassword(appUser.getPass()), grantList);
	        System.out.println(userDetails.getPassword());
	 
	        return userDetails;
	    }




}
