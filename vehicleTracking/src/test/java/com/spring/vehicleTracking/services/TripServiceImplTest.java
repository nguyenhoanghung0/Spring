package com.spring.vehicleTracking.services;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.services.TripServiceImpl;

@RunWith(SpringRunner.class)
public class TripServiceImplTest {
	
	@TestConfiguration
    static class TripServiceImplTestContextConfiguration {
  
        @Bean
        public TripServiceImpl tripService() {
            return new TripServiceImpl();
        }
    }
	
	@Autowired
    private TripServiceImpl tripService;
 
    @MockBean
    private TripRepository tripRepository;
    
    private static int vehicleId = 5;
    List<Trip> tripList = new ArrayList<>();
    List<Trip> fullTripList = new ArrayList<>();
    
    @Before
    public void setUp() {
        Trip firstTrip = new Trip(vehicleId, Duration.ofSeconds(10));
        Trip secondTrip = new Trip(vehicleId, Duration.ofHours(1));
        
        tripList.add(firstTrip);
        tripList.add(secondTrip);
        
        fullTripList.addAll(tripList);
        Trip thirdTrip = new Trip(6, Duration.ofMinutes(20));
        fullTripList.add(thirdTrip);
             
        Mockito.when(tripRepository.findByVehicleId(PageRequest.of(1, 3),
        		firstTrip.getVehicleId()))
        	.thenReturn(tripList);
        
        Mockito.when(tripRepository.findAll(PageRequest.of(1, 3)))
        	.thenReturn(new PageImpl<Trip>(fullTripList));
    }
    
    @Test
    public void findByVehicleIdTest() {
    	
    	List<Trip> foundList = tripService.findByVehicleId(vehicleId, 1);
    	
    	// Should return 2 trips out of total 3 trips 
    	assertEquals(foundList.size(), tripList.size());

    	// Verify the first trip
    	assertEquals(foundList.get(0).getVehicleId(), tripList.get(0).getVehicleId());
    	assertEquals(foundList.get(0).getDuration(), tripList.get(0).getDuration());
    	
    	// Verify the second trip
    	assertEquals(foundList.get(1).getVehicleId(), tripList.get(1).getVehicleId());
    	assertEquals(foundList.get(1).getDuration(), tripList.get(1).getDuration());
     }
    
    @Test
    public void findAllTest() {
    	List<Trip> foundList = tripService.findAll(1);
    	
    	// Should all 3 trips 
    	assertEquals(foundList.size(), fullTripList.size());
    	
    	// Verify the first trip
    	assertEquals(foundList.get(0).getVehicleId(), fullTripList.get(0).getVehicleId());
    	assertEquals(foundList.get(0).getDuration(), fullTripList.get(0).getDuration());
    	
    	// Verify the second trip
    	assertEquals(foundList.get(1).getVehicleId(), fullTripList.get(1).getVehicleId());
    	assertEquals(foundList.get(1).getDuration(), fullTripList.get(1).getDuration());
    	
    	// Verify the third trip
    	assertEquals(foundList.get(2).getVehicleId(), fullTripList.get(2).getVehicleId());
    	assertEquals(foundList.get(2).getDuration(), fullTripList.get(2).getDuration());
    }
}
