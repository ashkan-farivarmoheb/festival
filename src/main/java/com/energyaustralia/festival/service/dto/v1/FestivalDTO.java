package com.energyaustralia.festival.service.dto.v1;

public class FestivalDTO {

	private String name;

	public FestivalDTO() {
		super();
	}

	public FestivalDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
