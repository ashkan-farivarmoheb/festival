package com.energyaustralia.festival.client.dto;

public class Band {

	private String name;
	
	private String recordLabel;

	public Band() {
		super();
	}

	public Band(String name, String recordLabel) {
		super();
		this.name = name;
		this.recordLabel = recordLabel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
	
}
