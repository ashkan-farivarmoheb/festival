package com.energyaustralia.festival.api.v1;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energyaustralia.festival.service.RecordService;
import com.energyaustralia.festival.service.dto.v1.RecordDTO;

@RestController
@RequestMapping("/api/v1/records")
public class RecordResource {

	private final RecordService recordService;

	public RecordResource(RecordService recordService) {
		super();
		this.recordService = recordService;
	}

	@GetMapping
	public ResponseEntity<Set<RecordDTO>> getRecords() {

		return ResponseEntity.ok(recordService.getAllRecords());
	}

}
