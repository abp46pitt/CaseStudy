package com.teksystems.capstone.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bikes")
public class Bike {

	@ToString.Include
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ToString.Include
	@Column(name = "name")
	private String name;
	
	@ToString.Include
	@Column(name = "capacity")
	private Integer capacity;
	
	@ToString.Include
	@Column(name = "primary_color")
	private String primaryColor;
	
	@ToString.Include
	@Column(name = "secondary_color")
	private String secondaryColor;
	
	@ToString.Include
	@Column(name = "seat_type")
	private String seatType;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "user")
	private List<Rental> rentals;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
}
