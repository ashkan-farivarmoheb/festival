package com.energyaustralia.festival.service.dto.v1;

import java.util.Set;

public class RecordDTO {

	private String name;

	private Set<BandDTO> bands;

	public RecordDTO() {
		super();
	}

	public RecordDTO(String name, Set<BandDTO> bands) {
		super();
		this.name = name;
		this.bands = bands;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BandDTO> getBands() {
		return bands;
	}

	public void setBands(Set<BandDTO> bands) {
		this.bands = bands;
	}

}
