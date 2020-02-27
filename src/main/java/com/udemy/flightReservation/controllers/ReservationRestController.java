package com.udemy.flightReservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.flightReservation.dto.UpdateReservationDto;
import com.udemy.flightReservation.entities.Reservation;
import com.udemy.flightReservation.repos.ReservationRepository;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

	private static final Logger _log = LoggerFactory.getLogger(ReservationRestController.class);

	@Autowired
	private ReservationRepository reservationRepository;

	@RequestMapping("/{id}")
	public Reservation findById(@PathVariable("id") Long reservationId) {
		_log.info("Inside findById() and Id : {{id}}",reservationId);
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		if (reservation.isPresent()) {
			return reservation.get();
		}
		return null;

	}

	@RequestMapping
	public void updateReservation(@RequestBody UpdateReservationDto request) {

		Optional<Reservation> resOptional = reservationRepository.findById(request.getId());
		if (resOptional.isPresent()) {
			Reservation reservation = resOptional.get();

			reservation.setCheckedIn(request.getCheckedIn());
			reservation.setNumberOfBags(request.getNumberOfBags());

			reservationRepository.save(reservation);
		}

	}

}
