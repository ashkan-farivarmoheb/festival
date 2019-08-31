package com.energyaustralia.festival.service.util;

import java.util.function.Predicate;

import com.energyaustralia.festival.client.dto.Band;
import com.energyaustralia.festival.client.dto.MusicFestival;

public class FestivalPrediction {

	private FestivalPrediction() {
		super();
	}

	public static Predicate<MusicFestival> festivalNamePredicate() {
		return festival -> festival.getName() != null && !festival.getName().isEmpty();
	}

	public static Predicate<Band> bandRecordPredicate() {
		return band -> band.getRecordLabel() != null && !band.getRecordLabel().isEmpty();
	}

}
