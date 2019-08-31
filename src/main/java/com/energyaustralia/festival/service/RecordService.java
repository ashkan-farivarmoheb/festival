package com.energyaustralia.festival.service;

import java.util.Set;

import com.energyaustralia.festival.service.dto.v1.RecordDTO;

public interface RecordService {

	Set<RecordDTO> getAllRecords();

}
