package com.teksystems.capstone.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.capstone.database.entity.Rental;

@Repository
public interface RentalDAO extends JpaRepository<Rental, Long> {

	public Rental findById(Integer id);
}
