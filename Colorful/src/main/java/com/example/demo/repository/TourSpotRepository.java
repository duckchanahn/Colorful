package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Palette;
import com.example.demo.model.TourSpot;
import com.example.demo.model.TourSpotSummary;

public interface TourSpotRepository extends JpaRepository<TourSpot, Integer> {

	@Query("SELECT t.tourSpotId, t.images FROM TourSpot t WHERE t.personalColor = :personalColor")
	List<TourSpotSummary> findAllByPersonal(String personal);

	@Query("SELECT t FROM TourSpot t WHERE t.psyColor = :psyColor")
	List<TourSpotSummary> findAllByPsy(String psyColor);

	@Query("SELECT p FROM Palette p WHERE p.paletteId = :paletteId")
	Palette findPaletteById(int paletteId);

	@Query("SELECT p FROM Palette p WHERE p.customerId = :customerId")
	List<Palette> findPaletteByCustomerId(int customerId);

//	Palette savePalette(Palette palette);
	
	@Query("SELECT t FROM TourSpot t WHERE t.psyColor = :psyColor ORDER BY rand()")
	List<TourSpot> findRandomByPsyColor(String psyColor);
	
	@Query("SELECT t FROM TourSpot t WHERE t.personalColor = :personalColor ORDER BY rand()")
	List<TourSpot> findRandomByPersonalColor(String personalColor);

	@Query("SELECT t.images FROM TourSpot t WHERE t.tourSpotId = :id")
	String findImageById(int id);

	@Query("SELECT t FROM TourSpot t WHERE t.paletteId = :paletteId")
	List<TourSpot> findAllByPaletteId(int paletteId);

}