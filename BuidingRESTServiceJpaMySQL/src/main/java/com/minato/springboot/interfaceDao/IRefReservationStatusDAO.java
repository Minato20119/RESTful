/**
 * 
 */
package com.minato.springboot.interfaceDao;

import java.util.List;

import com.minato.springboot.entityRef.RefReservationStatus;

/**
 * @author Minato
 *
 */
public interface IRefReservationStatusDAO {

	List<RefReservationStatus> getAllRefReservationStatus();

	RefReservationStatus getRefReservationStatusById(int id);

	void addRefReservationStatus(RefReservationStatus refReservationStatus);

	void updateRefReservationStatus(RefReservationStatus refReservationStatus);

	void deleteRefReservationStatusById(int id);

	void deleteAllRefReservationStatus();

	boolean refReservationStatusExists(String name);
}
