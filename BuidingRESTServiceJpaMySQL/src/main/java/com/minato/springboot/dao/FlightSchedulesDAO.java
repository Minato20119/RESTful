/**
 * 
 */
package com.minato.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.FlightSchedules;
import com.minato.springboot.interfaceDao.IFlightSchedulesDAO;
import com.minato.springboot.intf.FlightSchedulesJPARepository;

/**
 * @author Minato
 *
 */
@Transactional
@Repository
public class FlightSchedulesDAO implements IFlightSchedulesDAO {

	@Autowired
	private FlightSchedulesJPARepository flightSchedulesJPARepository;

	@Override
	public List<FlightSchedules> getAllFlightSchedules() {
		// TODO Auto-generated method stub
		return flightSchedulesJPARepository.findAll();
	}

	@Override
	public FlightSchedules getFlightSchedulesById(int id) {
		// TODO Auto-generated method stub
		return flightSchedulesJPARepository.findOne(id);
	}

	@Override
	public void addFlightSchedules(FlightSchedules flightSchedules) {
		// TODO Auto-generated method stub
		flightSchedulesJPARepository.save(flightSchedules);
	}

	@Override
	public void updateFlightSchedules(FlightSchedules flightSchedules) {
		// TODO Auto-generated method stub
		FlightSchedules f = getFlightSchedulesById(flightSchedules.getId());
		f.setArrivalTime(flightSchedules.getArrivalTime());
		f.setDepartureTime(flightSchedules.getDepartureTime());
		f.setFlightNumber(flightSchedules.getFlightNumber());
		f.setOtherDetails(flightSchedules.getOtherDetails());
		flightSchedulesJPARepository.flush();
	}

	@Override
	public void deleteFlightSchedules(int id) {
		// TODO Auto-generated method stub
		flightSchedulesJPARepository.delete(id);
	}

	@Override
	public void deleteAllFlightSchedules() {
		// TODO Auto-generated method stub
		flightSchedulesJPARepository.deleteAll();
	}

	@Override
	public boolean customersExists() {
		// TODO Auto-generated method stub
		return flightSchedulesJPARepository.count() > 0 ? true : false;
	}

}
