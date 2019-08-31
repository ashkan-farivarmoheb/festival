package com.energyaustralia.festival.service.dto.v1;

import java.util.Set;

public class BandDTO {

	private String name;

	private Set<FestivalDTO> festivals;

	public BandDTO() {
		super();
	}

	public BandDTO(String name, Set<FestivalDTO> festivals) {
		super();
		this.name = name;
		this.festivals = festivals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FestivalDTO> getFestivals() {
		return festivals;
	}

	public void setFestivals(Set<FestivalDTO> festivals) {
		this.festivals = festivals;
	}

}
