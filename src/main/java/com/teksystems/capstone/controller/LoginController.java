package com.teksystems.capstone.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.RentalDAO;
import com.teksystems.capstone.database.dao.ReviewDAO;
import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.dao.UserRoleDAO;
import com.teksystems.capstone.database.entity.Rental;
import com.teksystems.capstone.database.entity.Review;
import com.teksystems.capstone.database.entity.User;
import com.teksystems.capstone.database.entity.UserRole;
import com.teksystems.capstone.form.CreateUserForm;
import com.teksystems.capstone.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserRoleDAO userRoleDao;

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticatedUserService authenticationService;
	
	@Autowired
	private RentalDAO rentalDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;

	@RequestMapping(value = { "/user/createuser" }, method = RequestMethod.GET)
	public ModelAndView createUser() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/create_user");

		log.debug("this is the get method");

		return response;
	}

	// only difference is the request method
	@RequestMapping(value = { "/user/createuser" }, method = RequestMethod.POST)
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/create_user");

		log.debug(form.toString());
		log.debug("this is the POST method");

		if (!form.getPassword().equals(form.getConfirmPassword())) {
			bindingResult.rejectValue("password", "error.user", "Passwords do not match");
		}

		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getDefaultMessage());
		}

		if (!bindingResult.hasErrors()) {
			User user = new User();
			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setEmail(form.getEmail());
			user.setPhone(form.getPhone());

			String encodedPassword = passwordEncoder.encode(form.getPassword());

			user.setPassword(encodedPassword);

			userDAO.save(user);

			UserRole ur = new UserRole();
			ur.setRoleName("USER");
			ur.setUserId(user.getId());

			userRoleDao.save(ur);
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}

		return response;
	}

	@RequestMapping(value = { "/user/profile" }, method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView response = new ModelAndView();
		response.setViewName("profile");

		User user = authenticationService.getCurrentUser();
		response.addObject("user", user);
		
		List<Rental> rentals = rentalDAO.findByUserId(user.getId());
		response.addObject("rentals", rentals);
		log.debug(rentals.toString());
		
		List<Review> reviews = reviewDAO.findByUserId(user.getId());
		response.addObject("reviews", reviews);
		
		return response;
	}

	@RequestMapping(value = { "/user/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/login");

		log.debug("login page");

		return response;
	}
}