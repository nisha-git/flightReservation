package com.udemy.flightReservation.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.flightReservation.dto.BookFlightDto;
import com.udemy.flightReservation.entities.Flight;
import com.udemy.flightReservation.entities.Passenger;
import com.udemy.flightReservation.entities.Reservation;
import com.udemy.flightReservation.repos.FlightRepository;
import com.udemy.flightReservation.repos.PassengerRepository;
import com.udemy.flightReservation.repos.ReservationRepository;
import com.udemy.flightReservation.utilities.EmailUtility;
import com.udemy.flightReservation.utilities.PdfGenerationUtility;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final String ITINEARERY_FILE_PATH = "D:\\reservations\\itinearery\\itinearery";

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private PdfGenerationUtility pdfUtility;
	
	@Autowired
	private EmailUtility emailUtility;

	@Override
	@Transactional
	public Long bookFlight(BookFlightDto bookFlightDto) {

		Reservation reservation = new Reservation();

		Optional<Flight> flight = flightRepository.findById(bookFlightDto.getFlightId());

		if (flight.isPresent()) {
			
			reservation.setFlight(flight.get());
			
			Passenger passenger = new Passenger();
			passenger.setFirstName(bookFlightDto.getFirstName());
			passenger.setMiddleName(bookFlightDto.getMiddleName());
			passenger.setLastName(bookFlightDto.getLastName());
			passenger.setEmail(bookFlightDto.getEmail());
			passenger.setPhone(bookFlightDto.getPhone());
            
			passengerRepository.save(passenger);
			
			reservation.setPassenger(passenger);
			reservation.setCheckedIn(false);
			
			reservation = reservationRepository.save(reservation);
			
			String filePath = ITINEARERY_FILE_PATH+reservation.getId()+".pdf";
			
			pdfUtility.generatePdfItinerary(reservation, filePath);
			
			emailUtility.sendMail(passenger.getEmail(), filePath);
		}
		return reservation.getId();
	}

}
