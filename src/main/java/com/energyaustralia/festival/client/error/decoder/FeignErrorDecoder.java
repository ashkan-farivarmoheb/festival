package com.energyaustralia.festival.client.error.decoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeignErrorDecoder.class);

	@Override
	public Exception decode(String methodKey, Response response) {
		LOGGER.error("Status code {}, methodKey = {}", response.status(), methodKey);
		return new ResponseStatusException(HttpStatus.valueOf(response.status()), response.reason());
	}
}
