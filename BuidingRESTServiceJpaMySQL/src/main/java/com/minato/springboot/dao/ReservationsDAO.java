/**
 * 
 */
package com.minato.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.Reservations;
import com.minato.springboot.interfaceDao.IReservationsDAO;
import com.minato.springboot.intf.ReservationsJPARepository;

/**
 * @author Minato
 *
 */
@Transactional
@Repository
public class ReservationsDAO implements IReservationsDAO {

	@Autowired
	private ReservationsJPARepository reservationsJPARepository;

	@Override
	public List<Reservations> getAllReservations() {
		// TODO Auto-generated method stub
		return reservationsJPARepository.findAll();
	}

	@Override
	public Reservations getReservationsById(int id) {
		// TODO Auto-generated method stub
		return reservationsJPARepository.findOne(id);
	}

	@Override
	public void addReservations(Reservations reservations) {
		// TODO Auto-generated method stub
		reservationsJPARepository.save(reservations);
	}

	@Override
	public void updateReservations(Reservations reservations) {
		// TODO Auto-generated method stub
		Reservations r = getReservationsById(reservations.getId());
		r.setCustomerName(reservations.getCustomerName());
		r.setDateOfFlight(reservations.getDateOfFlight());
		r.setDateReservationMade(reservations.getDateReservationMade());
		r.seteTicketNumber(reservations.geteTicketNumber());
		r.setOtherDetails(reservations.getOtherDetails());
		reservationsJPARepository.flush();
	}

	@Override
	public void deleteReservationsById(int id) {
		// TODO Auto-generated method stub
		reservationsJPARepository.delete(id);
	}

	@Override
	public void deleteAllReservations() {
		// TODO Auto-generated method stub
		reservationsJPARepository.deleteAll();
	}

	@Override
	public boolean reservationsExists(String name) {
		// TODO Auto-generated method stub
		return reservationsJPARepository.findByCustomerName(name) != null ? true : false;
	}

}
