package com.spring.vehicleTracking;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.model.Trip;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TripRepositoryTest {
	
	@Autowired
    private TripRepository tripRepository;
	
	@Test
	public void findByVehicleIdTest() {
		
		Trip trip = new Trip(1, Duration.ZERO);
		tripRepository.save(trip);
		
		Trip found = tripRepository.findByVehicleId(trip.getVehicleId()).get(0);
		
		assertEquals(found.getVehicleId(), trip.getVehicleId());
		assertEquals(found.getDuration(), trip.getDuration());
	}
}
