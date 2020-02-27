package com.udemy.flightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.flightReservation.entities.User;
import com.udemy.flightReservation.repos.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found for the email : "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getRoles());
	}

}
