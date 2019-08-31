package com.energyaustralia.festival.service.mapper;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.energyaustralia.festival.client.dto.Band;
import com.energyaustralia.festival.service.dto.v1.RecordDTO;

@Component
public class RecordMapper {

	private final BandMapper bandMapper;

	public RecordMapper(BandMapper bandMapper) {
		super();
		this.bandMapper = bandMapper;
	}

	public Function<Entry<String, List<Band>>, RecordDTO> toRecordDTO(Map<String, Set<String>> bandFestivals) {
		return m -> new RecordDTO(m.getKey(),
				m.getValue().stream().map(bandMapper.toBandDTO(bandFestivals)).collect(toSet()));
	}

}
