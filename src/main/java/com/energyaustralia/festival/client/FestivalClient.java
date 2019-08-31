package com.energyaustralia.festival.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.energyaustralia.festival.client.dto.MusicFestival;
import com.energyaustralia.festival.client.fallback.FestivalClientFallbackFactory;

@FeignClient(name = "festivalClient", url = "http://eacodingtest.digital.energyaustralia.com.au", fallbackFactory = FestivalClientFallbackFactory.class)
public interface FestivalClient {

	@GetMapping("/api/v1/festivals")
	ResponseEntity<List<MusicFestival>> getFestivals();

}
