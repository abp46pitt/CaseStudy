package com.teksystems.capstone.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditBike {

	private Integer id;
	
	@NotEmpty(message = "Name is required.")
	@Length(max = 200, message = "firstName must be less than 200 characters.")
	private String name;
	
	@NotEmpty(message = "Primary Color is required.")
	@Length(max = 200, message = "firstName must be less than 200 characters.")
	private String primaryColor;
	
	@NotEmpty(message = "Secondary Color is required.")
	@Length(max = 200, message = "firstName must be less than 200 characters.")
	private String secondaryColor;
	
	@NotEmpty(message = "Seat Type is required.")
	@Length(max = 200, message = "firstName must be less than 200 characters.")
	private String seatType;
	
	@NotEmpty(message = "Image is required.")
	@Length(max = 200, message = "firstName must be less than 200 characters.")
	private String image;
	
	@NotEmpty(message = "Description is required.")
	@Length(max = 400, message = "firstName must be less than 200 characters.")
	private String description;
}
