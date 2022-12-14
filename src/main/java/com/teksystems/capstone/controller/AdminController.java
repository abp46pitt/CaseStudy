package com.teksystems.capstone.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.BikeDAO;
import com.teksystems.capstone.database.entity.Bike;
import com.teksystems.capstone.form.EditBike;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

	@Autowired
	private BikeDAO bikeDAO;
	
	@RequestMapping(value = { "/admin/admintest" }, method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView response = new ModelAndView();
		response.setViewName("admin/admin");
		
		List<Bike> bikes = bikeDAO.findAll();
		response.addObject("bikes",bikes);
		
		log.debug("Get Method");
		
		
		return response;
	}
	
	@RequestMapping(value = { "/admin/edit_bike" }, method = RequestMethod.POST)
	public ModelAndView admin(@Valid EditBike form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("admin/admin");
		
		log.debug(form.toString());
		log.debug("Post method");
		
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getDefaultMessage());
		}
		
		if (!bindingResult.hasErrors()) {
			Bike bike = bikeDAO.findById(form.getId());
			
			bike.setName(form.getName());
			bike.setPrimaryColor(form.getPrimaryColor());
			bike.setSecondaryColor(form.getSecondaryColor());
			bike.setSeatType(form.getSeatType());
			bike.setImage(form.getImage());
			bike.setDescription(form.getDescription());
			
			bikeDAO.save(bike);
			log.debug("success");
		}else {
			log.debug("failure");
		}
		
		return response;
	}
}
