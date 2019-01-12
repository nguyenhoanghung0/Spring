package com.spring.vehicleTracking.services;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.dao.TripStatusRepository;
import com.spring.vehicletracking.model.Event;
import com.spring.vehicletracking.model.Event.Action;
import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.model.TripStatus;
import com.spring.vehicletracking.services.ReaderServiceImpl;

@RunWith(SpringRunner.class)
public class ReaderServiceImplTest {

	@TestConfiguration
    static class ReaderServiceImplTestContextConfiguration {
  
        @Bean
        public ReaderServiceImpl readerServiceImpl() {
            return new ReaderServiceImpl();
        }
    }
	
	@MockBean
    private ReaderServiceImpl readerServiceImpl;
	
	@MockBean
	private TripStatusRepository tripStatusRepository;
	
	@MockBean
    private TripRepository tripRepository;
	
	List<Event> eventList = new ArrayList<>();
	TripStatus tripStatusVehicle1;
	Pageable pageable = PageRequest.of(1, 3);
	
	@Before
    public void setUp() {
		
		// Init the event list
		eventList.add(new Event(1,Action.NONE));
		eventList.add(new Event(2,Action.START));
		eventList.add(new Event(3,Action.NONE));
		eventList.add(new Event(4,Action.STOP));
		eventList.add(new Event(1,Action.START));
		eventList.add(new Event(2,Action.STOP));
		eventList.add(new Event(3,Action.NONE));
		eventList.add(new Event(4,Action.NONE));
		
		tripStatusVehicle1 = new TripStatus(1, Action.START.toString(), Instant.now());
		
		Mockito.when(readerServiceImpl.getEventsFromQueue()).thenReturn(eventList);
		
		Mockito.when(tripStatusRepository.findByVehicleId(1)).thenReturn(tripStatusVehicle1);
		
		Trip trip = new Trip(2, Duration.ofSeconds(1));
		List<Trip> tripList = new ArrayList<>();
		tripList.add(trip);
		Mockito.when(tripRepository.findAll(pageable)).thenReturn(
				new PageImpl<Trip>(tripList));
	}
		
	@Test
	public void processEventsInQueueTest() {
		readerServiceImpl.processEventsInQueue();
		
		TripStatus foundTripStatus = tripStatusRepository.findByVehicleId(1);
		assertEquals(foundTripStatus.getVehicleId(), tripStatusVehicle1.getVehicleId());
		
		List<Trip> foundTrip = new ArrayList<>(); 
		tripRepository.findAll(pageable).forEach(foundTrip::add);
		
		assertEquals(foundTrip.size(), 1);
		assertEquals(foundTrip.get(0).getVehicleId(), 2);		
	}
	
}
