package com.teksystems.capstone.database.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "rentals")
public class Rental {

	@ToString.Include
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name="users_id")
	@JsonBackReference
	private User user;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name="bikes_id")
	@JsonBackReference
	private Bike bike;
}
