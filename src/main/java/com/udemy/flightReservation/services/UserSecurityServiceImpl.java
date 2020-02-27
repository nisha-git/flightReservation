package com.udemy.flightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

	@Autowired
	private UserDetailService userDetails;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public boolean login(String username, String password) {
        UserDetails userDetail = userDetails.loadUserByUsername(username);
        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetail, password,userDetail.getAuthorities());
        authenticationManager.authenticate(token);
        if(token.isAuthenticated()) {
        	SecurityContextHolder.getContext().setAuthentication(token);
        	return true;
        }
		return false;
	}

}
