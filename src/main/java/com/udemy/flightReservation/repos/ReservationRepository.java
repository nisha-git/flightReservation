package com.udemy.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.flightReservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
