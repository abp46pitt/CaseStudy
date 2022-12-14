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
@Table(name = "bikes")
public class Bike {

	@ToString.Include
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "name")
	private String name;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "capacity")
	private Integer capacity;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "primary_color")
	private String primaryColor;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "secondary_color")
	private String secondaryColor;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "seat_type")
	private String seatType;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "image")
	private String image;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Column(name = "description")
	private String description;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "price")
	private Integer price;
	
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
