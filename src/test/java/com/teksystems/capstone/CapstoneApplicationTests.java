package com.teksystems.capstone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teksystems.capstone.database.dao.BikeDAO;
import com.teksystems.capstone.database.dao.RentalDAO;
import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.Bike;
import com.teksystems.capstone.database.entity.Rental;
import com.teksystems.capstone.database.entity.User;

@SpringBootTest
class CapstoneApplicationTests {

	@Autowired
	private BikeDAO bikeDAO;
	
	@Autowired
	private RentalDAO rentalDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	// BikeDAO test
	@Test
	void bikeFindById() {
		// given
		Bike expected = new Bike();

		expected.setId(1);
		expected.setName("V-Rex");
		expected.setCapacity(1);
		expected.setPrimaryColor("Silver");
		expected.setSecondaryColor("Yellow");
		expected.setSeatType("Standard");
		expected.setImage("silver_vRex.jpg");
		expected.setPrice(20);

		// when
		Bike actual = bikeDAO.findById(1);

		// then
		Assertions.assertEquals(expected, actual);
	}

	// RentalDAO test
	@Test
	void rentalFindOverlap() {
		
		Assertions.assertEquals(rentalDAO.findOverlap(4, "2021-10-29 05:00:00", "2021-10-30 05:00:00").size(), 0);
	}
	
	// UserDAO test
	@ParameterizedTest
	@ValueSource(ints = {1, 7, 8, 9})
	void userFindById(int id) {
		User expected = new User();
		expected.setId(id);
		
		User actual = userDAO.findById(id);
		
		Assertions.assertEquals(expected.getId(),actual.getId());
	}
}
