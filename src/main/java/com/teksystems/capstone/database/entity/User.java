package com.teksystems.capstone.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

	@ToString.Include
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "first_name")
	private String firstName;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "last_name")
	private String lastName;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "email")
	private String email;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "phone")
	private String phone;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "password")
	private String password;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Rental> rentals;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Review> reviews;
}