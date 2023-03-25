package com.springBootMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootMvc.model.UserSession;


@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Integer>{

}
