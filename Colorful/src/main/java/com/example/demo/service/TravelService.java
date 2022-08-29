package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Palette;
import com.example.demo.model.PaletteLine;
import com.example.demo.model.Star;
import com.example.demo.model.TourSpot;
import com.example.demo.model.TourSpotSummary;
import com.example.demo.repository.PaletteLineRepository;
import com.example.demo.repository.PaletteRepository;
import com.example.demo.repository.StarRepository;
import com.example.demo.repository.TourSpotRepository;

@Service
public class TravelService {

	@Autowired
	TourSpotRepository tourSpotRepository;
	
	@Autowired
	PaletteRepository paletteRepository;
	
	@Autowired
	PaletteLineRepository paletteLineRepository;
	
	@Autowired
	StarRepository starRepository;
	
	public List<TourSpotSummary> recoomendPersonalColor(String personal) { // 아마 안 될 듯
		tourSpotRepository.findAllByPersonalColor(personal);
		
		List<TourSpotSummary> result = new ArrayList<>();
		for(TourSpot spot : tourSpotRepository.findAllByPersonalColor(personal)) {
			result.add(new TourSpotSummary(spot.getTourSpotId(), spot.getImages()));
		}
		return result;
		
//		System.out.println(personal + "!!!!!!!!!!!!!!!!!!!!!!!!!!!111");
//		System.out.println(tourSpotRepository.findAllByPersonal(personal));
//		
//		return null;
	}

	public List<TourSpotSummary> recoomendPsyColor(String psy) {
		List<TourSpotSummary> result = new ArrayList<>();
		for(TourSpot spot : tourSpotRepository.findAllByPsy(psy)) {
			result.add(new TourSpotSummary(spot.getTourSpotId(), spot.getImages()));
		}
		return result;
	}

	public TourSpot getTourSpotDetail(int tourSpotId) {
		return tourSpotRepository.findById(tourSpotId).get();
	}

	public Palette getPalette(int paletteId) {
		return this.paletteRepository.findById(paletteId).get();
	}
	
	public List<TourSpot> getPaletteDetail(int paletteId) {
		List<Integer> ids = this.paletteLineRepository.findAllByPaletteId(paletteId);
		List<TourSpot> result = new ArrayList<>();
		for(int tourSpotId : ids) {
			result.add(this.tourSpotRepository.findById(tourSpotId).get());
		}
		
		return result;
	}

	public List<Palette> getPaletteList(int customerId) {
		return this.paletteRepository.findPaletteByCustomerId(customerId);
	}

	public Palette addPalette(Palette palette) {
		return this.paletteRepository.save(palette);
	}

	@Transactional(readOnly = false)
	public void deletePalette(int paletteId) {
		this.paletteRepository.deleteById(paletteId);
		this.paletteLineRepository.deleteByPaletteId(paletteId);
	}

	public PaletteLine addTourSpotInPalette(int paletteId, int tourSpotId) {
		return this.paletteLineRepository.save(new PaletteLine(0, paletteId, tourSpotId));
	}

	@Transactional(readOnly = false)
	public int deleteTourSpotInPalette(int paletteLineId) {
		this.paletteLineRepository.deleteById(paletteLineId);
		return 1;
	}

	public TourSpot getRanmdomTourSpot(String psyColor, String personalColor) {
		int i = new Random().nextInt(2);
		if(i == 0) {
			return this.tourSpotRepository.findRandomByPsyColor(psyColor).get(0);
		} else {
			return this.tourSpotRepository.findRandomByPersonalColor(personalColor).get(0);
		}
	}
	
	public List<TourSpotSummary> getTourSpotListByCustomerId(int customerId) {
		// Star에서 여행지 id list 받아오고, 이걸로 이미지 받아오기
		List<Integer> idList = new ArrayList<>();
		idList = this.starRepository.findTourSpotIdListByCustomerId(customerId);
		ArrayList<TourSpotSummary> result = new ArrayList<>();
		for(int id : idList) {
			result.add(new TourSpotSummary(id, this.tourSpotRepository.findImageById(id))); 
		}
		return result;
	}

	@Transactional(readOnly = false)
	public Star addStar(int customerId, int tourSpotId) {
		Star star = new Star(0, customerId, tourSpotId);
		return this.starRepository.save(star);
	}

	@Transactional(readOnly = false)
	public int deleteStar(int starId) {
		this.starRepository.deleteById(starId);
		return 1;
	}

}
