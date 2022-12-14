package com.teksystems.capstone.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.teksystems.validation.EmailUnique;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserForm {

	private Integer id;
	
	@NotEmpty(message = "First Name is required.")
	@Length(max = 45, message = "firstName must be less than 200 characters.")
	private String firstName;
	
	@NotEmpty(message = "Last Name is required.")
	@Length(max = 45, message = "lastName must be less than 200 characters.")
	private String lastName;
	
	@NotEmpty(message = "Email is required.")
	@Length(max = 200, message = "Email must be less than 200 characters.")
	@EmailUnique(message = "Email already exists in the database.")
	private String email;
	
	@NotEmpty(message = "Phone is required.")
	@Length(max = 45, message = "phone must be less than 200 characters.")
	private String phone;
	
	@Pattern(regexp = "^[a-zA-Z0-9!@#]+$", message = "Password can only contain lowercase, uppercase, and special caracters")
	@Length(min = 8, message = "Password must be longer than 8 characters.")
	@Length(max = 25, message = "Password must be shorter than 25 characters.")
	private String password;
	
	@NotEmpty(message = "Confirm Password is required.")
	private String confirmPassword;

}
