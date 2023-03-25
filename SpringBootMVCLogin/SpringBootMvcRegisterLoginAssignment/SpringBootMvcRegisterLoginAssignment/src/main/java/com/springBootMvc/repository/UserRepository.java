package com.springBootMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootMvc.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
