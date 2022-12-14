package com.teksystems.capstone.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teksystems.capstone.database.entity.Rental;

@Repository
public interface RentalDAO extends JpaRepository<Rental, Long> {

	public Rental findById(Integer id);
	
	@Query(value = "SELECT * FROM rentals r WHERE bikes_id = :bikeId and :startTime < r.end_time AND :endTime > r.start_time", nativeQuery = true)
	public List<Rental> findOverlap(@Param("bikeId") Integer bikeId, @Param("startTime") String startTime, @Param("endTime") String endTime);
	
	@Query(value = "SELECT * FROM rentals WHERE bikes_id = :bikeId", nativeQuery = true)
	public List<Rental> findByBikeId(@Param("bikeId") Integer bikeId);
	
	@Query("SELECT r FROM Rental r WHERE r.user.id = :id")
	public List<Rental> findByUserId(Integer id);
	
//	@Query(value = "SELECT * FROM rentals WHERE users_id = :userId", nativeQuery = true)
//	public List<Rental> findByUserId(@Param("userId") Integer userId);
}
