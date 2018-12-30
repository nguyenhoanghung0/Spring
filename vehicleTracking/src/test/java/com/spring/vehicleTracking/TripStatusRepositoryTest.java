package com.spring.vehicleTracking;

import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.vehicletracking.dao.TripStatusRepository;
import com.spring.vehicletracking.model.TripStatus;
import com.spring.vehicletracking.model.Event.Action;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TripStatusRepositoryTest {
	
	@Autowired
    private TripStatusRepository tripStatusRepository;
	
	@Test
	public void findByVehicleIdTest() {
		
		TripStatus tripStatus = new TripStatus(1, Action.START.toString(), Instant.now());
		tripStatusRepository.save(tripStatus);
		
		TripStatus found = tripStatusRepository.findByVehicleId(tripStatus.getVehicleId());
		
		assertEquals(found.getVehicleId(), tripStatus.getVehicleId());		
	}
}
