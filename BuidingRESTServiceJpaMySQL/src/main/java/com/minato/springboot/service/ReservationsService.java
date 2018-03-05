/**
 * 
 */
package com.minato.springboot.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entity.Reservations;
import com.minato.springboot.interfaceDao.IReservationsDAO;

/**
 * @author Minato
 *
 */
@Service
public class ReservationsService {

	@Autowired
	private IReservationsDAO reservationsDAO;

	private static Set<Object> listObject;

	public List<Reservations> getAllReservations() {
		return reservationsDAO.getAllReservations();
	}

	public Reservations getReservationsById(int id) {
		Reservations reservations = reservationsDAO.getReservationsById(id);
		return reservations;
	}

	public void addReservations(Reservations reservations) {
		reservationsDAO.addReservations(reservations);
	}

	public void addReservationsPrepare(Object object) {
		if (object != null)
			listObject.add(object);
	}

	public synchronized boolean updateReservations(Reservations reservations) {
		if (reservationsDAO.reservationsExists(reservations.getCustomerName())) {
			return false;
		}

		reservationsDAO.addReservations(reservations);
		return true;
	}

	public void deleteReservationsById(int id) {
		reservationsDAO.deleteReservationsById(id);
	}

	public void deleteAllReservations() {
		reservationsDAO.deleteAllReservations();
	}
}
