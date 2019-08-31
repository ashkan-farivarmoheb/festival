package com.energyaustralia.festival.service.impl;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.energyaustralia.festival.client.FestivalClient;
import com.energyaustralia.festival.client.dto.Band;
import com.energyaustralia.festival.client.dto.MusicFestival;
import com.energyaustralia.festival.service.RecordService;
import com.energyaustralia.festival.service.dto.v1.RecordDTO;
import com.energyaustralia.festival.service.mapper.RecordMapper;
import com.energyaustralia.festival.service.util.FestivalPrediction;

@Service
public class RecordServiceImpl implements RecordService {

	private final FestivalClient festivalClient;

	private final RecordMapper recordMapper;

	public RecordServiceImpl(FestivalClient festivalClient, RecordMapper recordMapper) {
		super();
		this.festivalClient = festivalClient;
		this.recordMapper = recordMapper;
	}

	@Override
	public Set<RecordDTO> getAllRecords() {

		List<MusicFestival> festivals = festivalClient.getFestivals().getBody();

		// key -> festival name
		// value -> bands name
		Map<String, Set<String>> festivalBands = getFestivalBands(festivals);

		// key -> record name
		// value -> bands name
		Map<String, List<Band>> recordBands = getRecordBands(festivals);

		// key -> band name
		// value -> festivals name
		Map<String, Set<String>> bandFestivals = convertToBandFestivals(festivalBands);

		// map festivals to record bands
		return recordBands.entrySet().stream().map(recordMapper.toRecordDTO(bandFestivals)).collect(toSet());
	}

	private Map<String, List<Band>> getRecordBands(List<MusicFestival> festivals) {
		return festivals.stream().map(MusicFestival::getBands).flatMap(List<Band>::stream)
				.filter(FestivalPrediction.bandRecordPredicate()).collect(groupingBy(Band::getRecordLabel));
	}

	private Map<String, Set<String>> getFestivalBands(List<MusicFestival> festivals) {
		return festivals.stream().filter(FestivalPrediction.festivalNamePredicate())
				.collect(groupingBy(MusicFestival::getName,
						flatMapping(festival -> festival.getBands().stream().map(Band::getName), toSet())));
	}

	private Map<String, Set<String>> convertToBandFestivals(Map<String, Set<String>> festivalBands) {
		Map<String, Set<String>> bandFestivals = new HashMap<>();

		festivalBands.entrySet().forEach(entry -> entry.getValue().forEach(band -> {
			if (bandFestivals.containsKey(band)) {
				bandFestivals.get(band).add(entry.getKey());
			} else {
				Set<String> festivals = new HashSet<>();
				festivals.add(entry.getKey());
				bandFestivals.put(band, festivals);
			}
		}));

		return bandFestivals;
	}

}
