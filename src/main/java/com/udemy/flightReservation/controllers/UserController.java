package com.udemy.flightReservation.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.flightReservation.entities.User;
import com.udemy.flightReservation.repos.UserRepository;
import com.udemy.flightReservation.services.UserSecurityService;

@Controller
public class UserController {

	private static final Logger _log =  LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserSecurityService userSecurityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		_log.info("Inside showLogin()");
		return "/login/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister() {
		_log.info("Inside showRegister()");
		return "/login/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, @RequestParam String confirmPassword, ModelMap map) {
		_log.info("Inside registerUser() user :" + user);
		if (user.getPassword().equals(confirmPassword)) {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);
			map.addAttribute("msg", "Registration completed Successfully!!");
		} else {
			map.addAttribute("user",user);
			map.addAttribute("msg", "Opps! password is mismatched Please enter again..");
			return "/login/register";
		}
		return "/login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap map) {
        _log.info("inside login() where email :" + email);
		User user = userRepository.findByEmail(email);
		if (user != null && userSecurityService.login(email, password)) {
			map.addAttribute("msg", "Login Successful");
		} else {
			map.addAttribute("msg", "Login Failed");
		}
		return "searchflight";
	}

}
