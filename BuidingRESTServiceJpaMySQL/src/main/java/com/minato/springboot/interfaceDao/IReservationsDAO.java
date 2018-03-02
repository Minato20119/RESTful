/**
 * 
 */
package com.minato.springboot.interfaceDao;

import java.util.List;

import com.minato.springboot.entity.Reservations;

/**
 * @author Minato
 *
 */
public interface IReservationsDAO {

	List<Reservations> getAllReservations();

	Reservations getReservationsById(int id);

	void addReservations(Reservations reservations);

	void updateReservations(Reservations reservations);

	void deleteReservationsById(int id);

	void deleteAllReservations();

	boolean reservationsExists(String name);
}
