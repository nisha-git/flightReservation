package com.udemy.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.flightReservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
