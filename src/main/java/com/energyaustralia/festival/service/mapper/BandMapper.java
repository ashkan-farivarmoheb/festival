package com.energyaustralia.festival.service.mapper;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.energyaustralia.festival.client.dto.Band;
import com.energyaustralia.festival.service.dto.v1.BandDTO;
import com.energyaustralia.festival.service.dto.v1.FestivalDTO;

@Component
public class BandMapper {

	public Function<Band, BandDTO> toBandDTO(Map<String, Set<String>> bandFestivals) {
		return band -> {
			Set<String> festivals = Optional.ofNullable(bandFestivals.get(band.getName()))
					.orElse(new HashSet<String>());
			return new BandDTO(band.getName(), festivals.stream().map(FestivalDTO::new).collect(toSet()));
		};
	}
}
