package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/tourspot/detail")
	@ApiOperation("여행지 상세페이지")
	public TourSpot getTourSpotDetail(int tourSpotId) {
		System.out.println("여행지 상세페이지");
		return travelService.getTourSpotDetail(tourSpotId);
	}

	// O
	@PostMapping("/tourspot/random")
	@ApiOperation("랜덤 여행지 추천 - 홈")
	public TourSpot getRandomTourSpot(String psycolor, String personalcolor) {
		System.out.println("랜덤 여행지 추천 - 홈");
		return travelService.getRanmdomTourSpot(psycolor, personalcolor);
	}
	
	// O
	@GetMapping("/tourspotlist/random")
	@ApiOperation("랜덤 여행지 리스트 - 서치 페이지")
	public List<TourSpot> getRandomTourSpotList() {
		System.out.println("랜덤 여행지 리스트 - 서치 페이지");
		return travelService.getRanmdomTourSpotList();
	}

	// O
	@GetMapping("/tourspot/recommend/personalcolor")
	@ApiOperation("퍼스널컬러 추천")
	public List<TourSpotSummary> recommendPersonalColor(String personal) {
		return travelService.recoomendPersonalColor(personal);
	}

	// O	
	@GetMapping("/tourspot/recommend/psycolor")
	@ApiOperation("심리컬러 추천")
	public List<TourSpotSummary> recommendPsyColor(String psy) {
		return travelService.recoomendPsyColor(psy);
	}
	
	// 필터링 적용된 여행지 리스트 (DTO 만들어서 이미지랑 id만 전송하기)
	
	// O
	@GetMapping("/tourspot/palette/detail")
	@ApiOperation("여행코스 받아오기 - 여행코스 detail")
	public Palette getPalette(int paletteId) { //여기서는 팔레트만 받아오고 팔레트 상세페이지는 새로 만들기
		return travelService.getPalette(paletteId);
	}
	
	// O
	@GetMapping("/tourspot/palette/tourspot")
	@ApiOperation("여행코스 받아오기 - 여행지 리스트 받기")
	public List<TourSpot> getPaletteDetail( int paletteId) { //여기서는 팔레트만 받아오고 팔레트 상세페이지는 새로 만들기
		System.out.println("getPaletteDetail, paletteId : " + paletteId);
		return travelService.getPaletteDetail(paletteId);
	}
	
	// O
	@GetMapping("/tourspot/palette/list/{customerId}")
	@ApiOperation("여행코스 리스트 받아오기")
	public List<Palette> getPaletteList(@PathVariable("customerId") int customerId) {
		System.out.println("getPaletteList, customerId : " + customerId);
		return travelService.getPaletteList(customerId);
	}
	
	// O
	@PostMapping("/tourspot/add/palette")
	@ApiOperation("여행코스 만들기")
	public Palette addPalette(@RequestBody Palette palette) {
//		return null;
		return travelService.addPalette(palette);
	}
	
	// O
	@PostMapping("/tourspot/delete/palette")
	@ApiOperation("여행코스 삭제")
	public int deletePalette(int paletteId) {
		travelService.deletePalette(paletteId);
		return 1;
	}
	
	// O
	@PostMapping("/tourspot/palette/add")
	@ApiOperation("여행코스 여행지 추가")
	public int addTourSpotInPalette(int paletteId, int tourSpotId) {
		travelService.addTourSpotInPalette(paletteId, tourSpotId);
		return 1;
	}
	
	// O
	@PostMapping("/tourspot/palette/delete")
	@ApiOperation("여행코스 여행지 삭제")
	public int deleteTourSpotInPalette(@RequestBody HashMap<String, Object> param) {
		return travelService.deleteTourSpotInPalette((int)param.get("paletteLineId"));
	}

	

	// O
	@PostMapping("/tourspot/star/tourspotlist")
	@ApiOperation("찜목록 리스트 받아오기")
	public List<TourSpot> getTourSpotListByCustomerId(int customerId) {
		return travelService.getTourSpotListByCustomerId(customerId);
	}
	
	// O
	@GetMapping("/tourspot/star/check")
	@ApiOperation("찜 여부 확인")
	public Star getStarByCustomerIdANDTourSpotId(int customerId, int tourSpotId) {
		System.out.println("start 찜 여부 확인 -----------------" + " customer : " + customerId + ", tourSpotId : " + tourSpotId);
		System.out.println(travelService.getStarByCustomerIdANDTourSpotId(customerId, tourSpotId).getStarId());
		
		return travelService.getStarByCustomerIdANDTourSpotId(customerId, tourSpotId);
	}

	// O
	@PostMapping("/tourspot/star/add")
	@ApiOperation("찜목록 추가")
	public Star addStar(int customerId, int tourSpotId) {
		return travelService.addStar(customerId, tourSpotId); 
	}

	// O
	@PostMapping("/tourspot/star/delete")
	@ApiOperation("찜목록 삭제")
	public int deleteStar(int starId) {
		return travelService.deleteStar(starId);
	}
}
