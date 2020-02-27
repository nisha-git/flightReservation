package com.udemy.flightReservation.services;

import com.udemy.flightReservation.dto.BookFlightDto;

public interface ReservationService {

	public Long bookFlight(BookFlightDto bookFlightDto);
}
