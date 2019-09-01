package com.energyaustralia.festival.service;

import static com.energyaustralia.festival.util.FestivalUtil.createFourthWomanRecords;
import static com.energyaustralia.festival.util.FestivalUtil.createPacificRecords;
import static com.energyaustralia.festival.util.FestivalUtil.createXSRecordings;
import static com.energyaustralia.festival.util.FestivalUtil.getMusicFestivals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.energyaustralia.festival.client.FestivalClient;
import com.energyaustralia.festival.client.dto.MusicFestival;
import com.energyaustralia.festival.service.dto.v1.RecordDTO;
import com.energyaustralia.festival.service.impl.RecordServiceImpl;
import com.energyaustralia.festival.service.mapper.BandMapper;
import com.energyaustralia.festival.service.mapper.RecordMapper;

@RunWith(SpringRunner.class)
public class RecordServiceImplTest {

	@Mock
	private FestivalClient festivalClient;

	private RecordMapper recordMapper;

	private RecordService recordService;

	@Before
	public void init() {
		recordMapper = new RecordMapper(new BandMapper());
		recordService = new RecordServiceImpl(festivalClient, recordMapper);
	}

	@Test
	public void getAllRecords() {

		RecordDTO pacificRecords = createPacificRecords();
		RecordDTO xSRecordings = createXSRecordings();
		RecordDTO fourthWomanRecords = createFourthWomanRecords();

		ResponseEntity<List<MusicFestival>> musicFestivals = getMusicFestivals();

		when(festivalClient.getFestivals()).thenReturn(musicFestivals);

		Set<RecordDTO> records = recordService.getAllRecords();

		verify(festivalClient).getFestivals();
		
		assertThat(records).isNotNull().isNotEmpty();
		assertThat(records).hasSize(3);
		assertThat(records.contains(pacificRecords));
		assertThat(records.contains(xSRecordings));
		assertThat(records.contains(fourthWomanRecords));
	}

}
