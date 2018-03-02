/**
 * 
 */
package com.minato.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entity.Airlines;
import com.minato.springboot.entity.FlightSchedules;
import com.minato.springboot.interfaceDao.IAirlinesDAO;
import com.minato.springboot.interfaceDao.IFlightSchedulesDAO;

/**
 * @author Minato
 *
 */
@Service
public class FlightSchedulesService {

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IFlightSchedulesDAO flightSchedulesDAO;

	@Autowired
	private IAirlinesDAO airlinesDAO;

	public FlightSchedules getFlightSchedulesById(int id) {
		FlightSchedules flightSchedules = flightSchedulesDAO.getFlightSchedulesById(id);
		return flightSchedules;
	}

	public List<FlightSchedules> getAllFlightSchedules() {
		return flightSchedulesDAO.getAllFlightSchedules();
	}

	public void addFlightSchedules(Airlines airlines) {
		FlightSchedules f1 = new FlightSchedules((int) (counter.getAndIncrement()), new Date(), new Date(),
				"This is other details flight " + counter);
		FlightSchedules f2 = new FlightSchedules((int) (counter.getAndIncrement()), new Date(), new Date(),
				"This is other details flight " + counter);
		
		f1.setAirlines(airlines);
		f2.setAirlines(airlines);
		airlines.getFlightSchedules().add(f1);
		airlines.getFlightSchedules().add(f2);
		airlinesDAO.addAirlines(airlines);
	}

	public void updateFlightSchedules(FlightSchedules customers) {
		flightSchedulesDAO.updateFlightSchedules(customers);
	}

	public void deleteFlightSchedules(int id) {
		flightSchedulesDAO.deleteFlightSchedules(id);
	}

	public void deleteAllFlightSchedules() {
		flightSchedulesDAO.deleteAllFlightSchedules();
	}
}
