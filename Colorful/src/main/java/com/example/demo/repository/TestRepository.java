package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Customer;

public interface TestRepository extends JpaRepository<Customer, Integer> {


	@Modifying
	@Query("UPDATE Customer c SET c.personal_color = :personal_color WHERE c.user_id = user_id")
	int saveByUserId(@Param("user_id")int user_id, @Param("personal_color")String personal_color);
	
	

}

