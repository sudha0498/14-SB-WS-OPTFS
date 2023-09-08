package com.cjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.entity.Admin;
import com.cjc.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

	boolean existsByUsername(String username);

	boolean existsByPassword(String Password);

	Parent findByUsername(String username);

}
