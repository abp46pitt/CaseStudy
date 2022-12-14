package com.teksystems.capstone.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.capstone.database.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	public User findById(Integer id);
	
	public User findByEmail(String email);
	
	public <S extends User> S save(S user);
}
