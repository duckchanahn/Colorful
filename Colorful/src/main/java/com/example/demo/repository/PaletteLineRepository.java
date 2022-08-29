package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Palette;
import com.example.demo.model.PaletteLine;

public interface PaletteLineRepository extends JpaRepository<PaletteLine, Integer> {

	@Modifying
	@Query("DELETE FROM PaletteLine p WHERE p.paletteId = :paletteId")
	void deleteByPaletteId(int paletteId);

	@Query("SELECT p.tourSpotId FROM PaletteLine p WHERE p.paletteId = :paletteId")
	List<Integer> findAllByPaletteId(int paletteId);

//	@Modifying
//	Palette save(Palette palette);

}
