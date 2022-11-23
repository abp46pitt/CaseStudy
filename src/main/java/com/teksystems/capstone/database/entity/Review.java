package com.teksystems.capstone.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "reviews")
public class Review {

	@ToString.Include
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ToString.Include
	@Column(columnDefinition = "MEDIUMTEXT")
	private String comment;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="users_id")
	private User user;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="bikes_id")
	private Bike bike;
}
