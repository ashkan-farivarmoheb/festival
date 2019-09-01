package com.energyaustralia.festival.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.energyaustralia.festival.client.dto.Band;
import com.energyaustralia.festival.client.dto.MusicFestival;
import com.energyaustralia.festival.service.dto.v1.BandDTO;
import com.energyaustralia.festival.service.dto.v1.FestivalDTO;
import com.energyaustralia.festival.service.dto.v1.RecordDTO;

public class FestivalUtil {

	public static RecordDTO createPacificRecords() {
		RecordDTO pacificRecords = new RecordDTO();
		pacificRecords.setName("Pacific Records");
		
		Set<FestivalDTO> festivals = getFestivalDTOs("LOL-palooza");		
		Set<BandDTO> bands = getBandDTOs(festivals, "Frank Jupiter");
		
		pacificRecords.setBands(bands);
		
		return pacificRecords;
	}

	public static RecordDTO createXSRecordings() {
		RecordDTO pacificRecords = new RecordDTO();
		pacificRecords.setName("XS Recordings");
		
		Set<FestivalDTO> festivals = getFestivalDTOs("LOL-palooza");
		Set<BandDTO> bands = getBandDTOs(festivals, "Werewolf Weekday");

		pacificRecords.setBands(bands);
		
		return pacificRecords;
	}

	public static ResponseEntity<List<MusicFestival>> getMusicFestivals() {

		List<MusicFestival> festivals = new ArrayList<>();

		MusicFestival mf = new MusicFestival();
		mf.setName("LOL-palooza");
		mf.setBands(getBands());

		festivals.add(mf);

		return ResponseEntity.ok(festivals);
	}
	
	public static RecordDTO createFourthWomanRecords() {
		RecordDTO pacificRecords = new RecordDTO();
		pacificRecords.setName("Fourth Woman Records");
		
		Set<FestivalDTO> festivals = getFestivalDTOs("LOL-palooza");
		
		Set<BandDTO> bands = getBandDTOs(festivals, "Jill Black");

		pacificRecords.setBands(bands);
		
		return pacificRecords;
	}
	
	private static Set<FestivalDTO> getFestivalDTOs(String name) {
		Set<FestivalDTO> festivals = new HashSet<>();
		festivals.add(new FestivalDTO(name));
		return festivals;
	}	

	private static Set<BandDTO> getBandDTOs(Set<FestivalDTO> festivals, String name) {
		Set<BandDTO> bands = new HashSet<>();
		bands.add(new BandDTO(name, festivals));
		return bands;
	}
	
	

	private static List<Band> getBands() {
		List<Band> bands = new ArrayList<>();
		bands.add(new Band("Jill Black", "Fourth Woman Records"));
		bands.add(new Band("Frank Jupiter", "Pacific Records"));
		bands.add(new Band("Winter Primates", ""));
		bands.add(new Band("Werewolf Weekday", "XS Recordings"));
		return bands;
	}
}
