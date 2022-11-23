package com.teksystems.capstone.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.capstone.database.entity.Bike;


@Repository
public interface BikeDAO extends JpaRepository<Bike, Long> {

	public Bike findById(Integer id);
}