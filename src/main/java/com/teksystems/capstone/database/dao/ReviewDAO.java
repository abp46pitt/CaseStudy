package com.teksystems.capstone.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.capstone.database.entity.Review;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long> {

	public Review findById(Integer id);
}