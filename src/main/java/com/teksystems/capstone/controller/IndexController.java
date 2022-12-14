package com.teksystems.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.BikeDAO;
import com.teksystems.capstone.database.dao.ReviewDAO;
import com.teksystems.capstone.database.entity.Bike;
import com.teksystems.capstone.database.entity.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private BikeDAO bikeDAO;
	
	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView home() {

		ModelAndView response = new ModelAndView();
		response.setViewName("index");
		
		return response;
	}
	
	@RequestMapping(value = {"/info/all-bikes"}, method = RequestMethod.GET)
	public ModelAndView allBikes() {
		ModelAndView response = new ModelAndView();
		response.setViewName("allBikes");
		
		List<Bike> bikes = bikeDAO.findAll();
		response.addObject("bikes",bikes);
		
		return response;
	}
	
	@RequestMapping(value = {"/info/bikes/{id}"}, method = RequestMethod.GET)
	public ModelAndView bikeInfo(@PathVariable Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("bikeInfo");
		
		Bike bike = bikeDAO.findById(id);
		log.debug(bike.toString());
		response.addObject("bike",bike);
		
		List<Review> reviews = reviewDAO.findByBikeId(id);
		log.debug(reviews.toString());
		response.addObject("reviews",reviews);
		
		return response;
	}
	
}