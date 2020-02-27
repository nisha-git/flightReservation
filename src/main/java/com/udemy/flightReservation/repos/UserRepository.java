package com.udemy.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.flightReservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
