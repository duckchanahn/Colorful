package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Star;

public interface StarRepository extends JpaRepository<Star, Integer> {

	@Query("SELECT s.tourSpotId FROM Star s WHERE s.customerId = :customerId")
	List<Integer> findTourSpotIdListByCustomerId(int customerId);

//	@Modifying
//	@Query("INSERT INTO Star s (s.customerId, s.tourSpotId) values (:customerId, :tourSpotId)")
//	int save(int customerId, int tourSpotId);
	

}

