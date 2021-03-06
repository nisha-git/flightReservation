package com.udemy.flightReservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.flightReservation.entities.Flight;
import com.udemy.flightReservation.repos.FlightRepository;

@Controller
public class FlightController {
	
    private static final Logger _log = (Logger) LoggerFactory.getLogger(FlightController.class);
    
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping(value = "/findflight", method = RequestMethod.GET)
	public String findflight(@RequestParam String from, @RequestParam String to,
			@RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap map) {
		_log.info("inside  findflight() from : "+from +" To: " +to +" Departure Date: " +departureDate);
		List<Flight> flights = flightRepository.findFlight(from, to, departureDate);
		map.addAttribute("flights", flights);
		return "searchflight";
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String bookFlight(@RequestParam("flightId") long flightId, ModelMap map) {
		_log.info("inside bookFlight()");
		map.addAttribute("flightId", flightId);
		return "bookFlight";
	}
	
	@RequestMapping(value = "/admin/addFlight", method = RequestMethod.GET)
	public String showAddFlight() {
		_log.info("inside showAddFlight()");
		return "addFlight";
	}

}
