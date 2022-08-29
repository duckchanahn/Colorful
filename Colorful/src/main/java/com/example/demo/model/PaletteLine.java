package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="palette_line")
public class PaletteLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int paletteLineId;
	int paletteId;
	int tourSpotId;
	
	public PaletteLine() {
		super();
		
		this.paletteLineId = 0;
		this.paletteId = 0;
		this.tourSpotId = 0;
	}
	
	public PaletteLine(int paletteLineId, int paletteId, int tourSpotId) {
		super();
		
		this.paletteLineId = paletteLineId;
		this.paletteId = paletteId;
		this.tourSpotId = tourSpotId;
	}

	public int getPaletteLineId() {
		return paletteLineId;
	}

	public void setPaletteLineId(int paletteLineId) {
		this.paletteLineId = paletteLineId;
	}

	public int getPaletteId() {
		return paletteId;
	}

	public void setPaletteId(int paletteId) {
		this.paletteId = paletteId;
	}

	public int getTourSpotId() {
		return tourSpotId;
	}

	public void setTourSpotId(int tourSpotId) {
		this.tourSpotId = tourSpotId;
	}


}
