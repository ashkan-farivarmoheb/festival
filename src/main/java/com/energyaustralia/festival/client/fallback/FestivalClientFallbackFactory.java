package com.energyaustralia.festival.client.fallback;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.energyaustralia.festival.client.FestivalClient;

import feign.hystrix.FallbackFactory;

@Component
public class FestivalClientFallbackFactory implements FallbackFactory<FestivalClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FestivalClientFallbackFactory.class);

	@Override
	public FestivalClient create(Throwable cause) {
		checkException(cause);

		LOGGER.error(cause.getMessage());
		return () -> ResponseEntity.ok(Collections.emptyList());
	}

	private void checkException(Throwable cause) {
		if (cause instanceof ResponseStatusException)
			throw (ResponseStatusException) cause;
	}

}
