package com.teksystems.capstone.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.BikeDAO;
import com.teksystems.capstone.database.dao.RentalDAO;
import com.teksystems.capstone.database.entity.Bike;
import com.teksystems.capstone.database.entity.Rental;
import com.teksystems.capstone.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RentalController {

	@Autowired
	private RentalDAO rentalDAO;

	@Autowired
	private BikeDAO bikeDAO;

	@Autowired
	private AuthenticatedUserService authenticationService;

	@RequestMapping(value = { "/rental/rent_bike/{id}" }, method = RequestMethod.GET)
	public ModelAndView createUser(@PathVariable Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("rental/rent");
		Bike bike = bikeDAO.findById(id);
		response.addObject("bike", bike);
		response.addObject("rentals", rentalDAO.findByBikeId(id));
		response.addObject("user", authenticationService.getCurrentUser());
		log.debug(rentalDAO.findByBikeId(id).toString());
		return response;
	}

	@ResponseBody
	@RequestMapping(value = { "/ajaxcall" }, method = RequestMethod.GET)
	public String rentalAjax(@RequestParam String startDate, @RequestParam String endDate,
			@RequestParam Integer bikeId) {
		log.debug("times: " + startDate + " " + endDate);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		startDate = formatDate(startDate)+" 05:00:00";
		log.debug("startDate "+startDate);
		endDate = formatDate(endDate)+" 05:00:00";
		log.debug("endDate "+endDate);
		
		System.setProperty("user.timezone", "UTC");

		try {
			Date start = formatter.parse(startDate);
			log.debug(start.toString());
			Date end = formatter.parse(endDate);
			log.debug(end.toString());

			if (start.compareTo(end) > 0) {
				return "Invalid Dates";
			}

			log.debug(rentalDAO.findOverlap(bikeId, startDate, endDate).toString());

			if (rentalDAO.findOverlap(bikeId, startDate, endDate).isEmpty()) {
				Rental rental = new Rental();
				rental.setStartTime(start);
				rental.setEndTime(end);
				rental.setUser(authenticationService.getCurrentUser());
				rental.setBike(bikeDAO.findById(bikeId));

				rentalDAO.save(rental);

				return "Successfully added rental";
			} else {
				log.debug("Date overlap");
				return "Date overlap, could not add rental";
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return "Error";
		}
	}

	public String formatDate(String inDate) {
		SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
		SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
		
	    String outDate = "";
	    if (inDate != null) {
	        try {
	            Date date = inSDF.parse(inDate);
	            outDate = outSDF.format(date);
	        } catch (ParseException ex) {
	            System.out.println("Unable to format date: " + inDate + ex.getMessage());
	            ex.printStackTrace();
	        }
	    }
	    return outDate;
	  }
}