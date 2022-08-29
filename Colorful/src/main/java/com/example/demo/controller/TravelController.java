package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Palette;
import com.example.demo.model.Star;
import com.example.demo.model.TourSpot;
import com.example.demo.model.TourSpotSummary;
import com.example.demo.service.TravelService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TravelController {
	
	@Autowired
	TravelService travelService;
	

	// O
	@PostMapping("/tourspot/random")
	@ApiOperation("랜덤 여행지 추천 - 홈")
	public TourSpot getRandomTourSpot(@RequestBody HashMap<String, Object> param) {
		return travelService.getRanmdomTourSpot((String)param.get("psycolor"), (String)param.get("personalcolor"));
	}

	// O
	@GetMapping("/test/personalcolor")
	@ApiOperation("퍼스널컬러 추천")
	public List<TourSpotSummary> recommendPersonalColor(String personal) {
		return travelService.recoomendPersonalColor(personal);
	}

	// O	
	@GetMapping("/test/psycolor")
	@ApiOperation("심리컬러 추천")
	public List<TourSpotSummary> recommendPsyColor(String psy) {
		return travelService.recoomendPsyColor(psy);
	}
	
	// 필터링 적용된 여행지 리스트 (DTO 만들어서 이미지랑 id만 전송하기)

	// O
	@GetMapping("/tourspot")
	@ApiOperation("여행지 상세페이지")
	public TourSpot getTourSpotDetail(int tourSpotId) {
		return travelService.getTourSpotDetail(tourSpotId);
	}
	
	// O
	@GetMapping("/palette/list")
	@ApiOperation("여행코스 리스트 받아오기")
	public List<Palette> getPaletteList(int customerId) {
		return travelService.getPaletteList(customerId);
	}
	
	// O
	@GetMapping("/palette")
	@ApiOperation("여행코스 받아오기 - 여행코스 detail")
	public Palette getPalette(int paletteId) { //여기서는 팔레트만 받아오고 팔레트 상세페이지는 새로 만들기
		return travelService.getPalette(paletteId);
	}
	
	// O
	@GetMapping("/palette/detail")
	@ApiOperation("여행코스 받아오기 - 여행지 리스트 받기")
	public List<TourSpot> getPaletteDetail(int paletteId) { //여기서는 팔레트만 받아오고 팔레트 상세페이지는 새로 만들기
		return travelService.getPaletteDetail(paletteId);
	}
	
	// O
	@PostMapping("/add/palette")
	@ApiOperation("여행코스 만들기")
	public Palette addPalette(@RequestBody Palette palette) {
//		return null;
		return travelService.addPalette(palette);
	}
	
	// O
	@PostMapping("/delete/palette")
	@ApiOperation("여행코스 삭제")
	public int deletePalette(int paletteId) {
		travelService.deletePalette(paletteId);
		return 1;
	}
	
	// O
	@PostMapping("/palette/add")
	@ApiOperation("여행코스 여행지 추가")
	public int addTourSpotInPalette(@RequestBody HashMap<String, Object> param) {
		travelService.addTourSpotInPalette((int)param.get("paletteId"), (int)param.get("tourSpotId"));
		return 1;
	}
	
	// O
	@PostMapping("/palette/delete")
	@ApiOperation("여행코스 여행지 삭제")
	public int deleteTourSpotInPalette(@RequestBody HashMap<String, Object> param) {
		return travelService.deleteTourSpotInPalette((int)param.get("paletteLineId"));
	}

	
	// 찜목록 여행지리스트 -> 여기도 summary로 받기
	@GetMapping("/star/tourspotlist")
	@ApiOperation("찜목록 리스트 받아오기")
	public List<TourSpotSummary> getTourSpotListByCustomerId(int customerId) {
		return travelService.getTourSpotListByCustomerId(customerId);
	}
	
	@PostMapping("/star/add")
	@ApiOperation("찜목록 추가")
	public Star addStar(@RequestBody HashMap<String, Object> param) {
		return travelService.addStar((int)param.get("customerId"), (int)param.get("tourSpotId")); 
	}

	@PostMapping("/star/delete")
	@ApiOperation("찜목록 삭제")
	public int deleteStar(@RequestBody HashMap<String, Object> param) {
		return travelService.deleteStar((int)param.get("starId"));
	}
}
