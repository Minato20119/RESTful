/**
 * 
 */
package com.minato.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entity.FlightSchedules;
import com.minato.springboot.interfaceDao.IFlightSchedulesDAO;

/**
 * @author Minato
 *
 */
@Service
public class FlightSchedulesService {

	@Autowired
	private IFlightSchedulesDAO flightSchedulesDAO;

	public FlightSchedules getFlightSchedulesById(int id) {
		FlightSchedules flightSchedules = flightSchedulesDAO.getFlightSchedulesById(id);
		return flightSchedules;
	}

	public List<FlightSchedules> getAllFlightSchedules() {
		return flightSchedulesDAO.getAllFlightSchedules();
	}

	public void addFlightSchedules(FlightSchedules flightSchedules) {

		flightSchedulesDAO.addFlightSchedules(flightSchedules);
	}

	public void addFlightSchedulesByIt(FlightSchedules flightSchedules) {
		flightSchedulesDAO.addFlightSchedules(flightSchedules);
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
