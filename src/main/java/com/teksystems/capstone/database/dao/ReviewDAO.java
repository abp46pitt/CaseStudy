package com.teksystems.capstone.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teksystems.capstone.database.entity.Review;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long> {

	public Review findById(Integer id);
	
	@Query(value = "SELECT * FROM reviews r WHERE r.bikes_id=:id", nativeQuery = true)
	public List<Review> findByBikeId(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM reviews WHERE users_id = :userId", nativeQuery = true)
	public List<Review> findByUserId(@Param("userId") Integer userId);
}