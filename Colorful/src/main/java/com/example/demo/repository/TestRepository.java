package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Customer;
import com.example.demo.model.PsycologicalTestAnswer;
import com.example.demo.model.PsycologicalTestQuestion;

public interface TestRepository extends JpaRepository<Customer, Integer> {

	

//	@Modifying
//	@Query("UPDATE Customer r SET r.password = :password WHERE r.customerId = :customerId")
//	int updateUserPassword(@Param("customerId")int customerId, @Param("password")String password);

	@Modifying
	@Query("UPDATE Customer c SET c.personalColor = :personalColor WHERE c.customerId = :customerId")
	int saveByUserId(int customerId, String personalColor);

	@Query("SELECT p FROM PsycologicalTestQuestion p")
	List<PsycologicalTestQuestion> getPsycologicalQuestion();
	
	@Query("SELECT p FROM PsycologicalTestAnswer p")
	List<PsycologicalTestAnswer> getPsycologicalAnswer();
	
	

}

