package com.example.demo.model;

//@Entity
//@Table(name="traveldestination")
public class TravelDestination {

	int travel_destination_id;
	String overview;
	String address;
	String hompage;
	String telephone;
	String holiday;
	String parking;
	String toilet;
	String fee;
	String images;
	String color_travel_destination;
	
	
	public TravelDestination() {
		super();
		
		this.travel_destination_id = 0;
		this.overview = "";
		this.address = "";
		this.hompage = "";
		this.telephone = "";
		this.holiday = "";
		this. parking = "";
		this. toilet = "";
		this. fee = "";
		this. images = "";
		this. color_travel_destination = "";
	}
	
	public TravelDestination(int travel_destination_id,
			String overview,
			String address,
			String hompage,
			String telephone,
			String holiday,
			String parking,
			String toilet,
			String fee,
			String images,
			String color_travel_destination
			) {
		super();
		
		this.travel_destination_id = travel_destination_id;
		this. overview = overview;
		this. address = address;
		this. hompage = hompage;
		this. telephone = telephone;
		this. holiday = holiday;
		this. parking = parking;
		this. toilet = toilet;
		this. fee = fee;
		this. images = images;
		this. color_travel_destination = color_travel_destination;
	}
	

	public int getTravel_destination_id() {
		return travel_destination_id;
	}

	public void setTravel_destination_id(int travel_destination_id) {
		this.travel_destination_id = travel_destination_id;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHompage() {
		return hompage;
	}

	public void setHompage(String hompage) {
		this.hompage = hompage;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getToilet() {
		return toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getColor_travel_destination() {
		return color_travel_destination;
	}

	public void setColor_travel_destination(String color_travel_destination) {
		this.color_travel_destination = color_travel_destination;
	}
	
}
