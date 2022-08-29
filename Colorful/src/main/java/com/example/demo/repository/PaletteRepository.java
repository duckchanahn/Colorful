package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Palette;
import com.example.demo.model.PaletteLine;

public interface PaletteRepository extends JpaRepository<Palette, Integer> {

	@Query("SELECT p FROM Palette p WHERE p.paletteId = :paletteId")
	Palette findPaletteById(int paletteId);

	@Query("SELECT p FROM Palette p WHERE p.customerId = :customerId")
	List<Palette> findPaletteByCustomerId(int customerId);

	@Query("SELECT p FROM Palette p WHERE p.paletteId = :paletteId")
	String findTourSpotListByPaletteId(int paletteId);
	
//	@Modifying
//	@Query("UPDATE Palette p SET p.listTourSpotId = :tourSpotIdList WHERE p.paletteId = :paletteId")
//	Palette updateTourSpotListByPaletteId(int paletteId, String tourSpotIdList);

//	@Modifying
//	Palette save(Palette palette);

}
