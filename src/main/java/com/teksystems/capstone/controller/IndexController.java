package com.teksystems.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.BikeDAO;
import com.teksystems.capstone.database.dao.RentalDAO;
import com.teksystems.capstone.database.dao.ReviewDAO;
import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.Bike;
import com.teksystems.capstone.database.entity.Rental;
import com.teksystems.capstone.database.entity.Review;
import com.teksystems.capstone.database.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RentalDAO rentalDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private BikeDAO bikeDAO;
	
	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash(@RequestParam(required = false) String search,
			@RequestParam(required = false) String instructor) {

		User user = userDAO.findById(1);
		log.info(user.toString());
		
		Rental rental = rentalDAO.findById(1);
		log.info(rental.toString() + " " + rental.getBike().getName() + " " + rental.getUser().getFirstName());
		
		Review review = reviewDAO.findById(1);
		log.info(review.toString() + " " + rental.getBike().getName() + " " + rental.getUser().getFirstName());
		
		Bike bike = bikeDAO.findById(1);
		log.info(bike.toString());
		return null;
	}
}
