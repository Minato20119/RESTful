/**
 * 
 */
package com.minato.springboot.interfaceDao;

import java.util.List;

import com.minato.springboot.entity.FlightSchedules;

/**
 * @author Minato
 *
 */
public interface IFlightSchedulesDAO {

	List<FlightSchedules> getAllFlightSchedules();

	FlightSchedules getFlightSchedulesById(int id);

	void addFlightSchedules(FlightSchedules flightSchedules);

	void updateFlightSchedules(FlightSchedules flightSchedules);

	void deleteFlightSchedules(int id);

	void deleteAllFlightSchedules();

	boolean flightSchedulesExists();
}
