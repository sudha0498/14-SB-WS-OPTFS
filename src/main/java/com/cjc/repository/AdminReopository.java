package com.cjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.entity.Admin;


@Repository
public interface AdminReopository extends JpaRepository<Admin, Integer> {
	
	boolean existsByUsername(String username);
	
	boolean existsByPassword(String password);
	
	Admin findByUsername(String username); 

}
