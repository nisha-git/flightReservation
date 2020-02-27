package com.udemy.flightReservation.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.udemy.flightReservation.dto.BookFlightDto;
import com.udemy.flightReservation.services.ReservationService;

@Controller
public class ReservationController {

	private static final Logger _log = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/bookFlight", method = RequestMethod.POST)
	public String bookFlightNow(@ModelAttribute BookFlightDto bookFlightDto, ModelMap map) {
		_log.info("inside bookFlightNow()");
		Long bookedFlightId = reservationService.bookFlight(bookFlightDto);
		map.addAttribute("bookedFlightId", bookedFlightId);
		return "confirmation";
	}
}
