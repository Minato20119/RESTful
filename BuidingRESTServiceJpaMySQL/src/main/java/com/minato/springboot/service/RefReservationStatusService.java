/**
 * 
 */
package com.minato.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entityRef.RefReservationStatus;
import com.minato.springboot.interfaceDao.IRefReservationStatusDAO;

/**
 * @author Minato
 *
 */
@Service
public class RefReservationStatusService {

	@Autowired
	private IRefReservationStatusDAO refReservationStatusDAO;

	public List<RefReservationStatus> getAllRefReservationStatus() {
		return refReservationStatusDAO.getAllRefReservationStatus();
	}

	public RefReservationStatus getRefReservationStatusById(int id) {
		RefReservationStatus refReservationStatus = refReservationStatusDAO.getRefReservationStatusById(id);
		return refReservationStatus;
	}

	public synchronized boolean addRefReservationStatus(RefReservationStatus refReservationStatus) {
		if (refReservationStatusDAO
				.refReservationStatusExists(refReservationStatus.getReservatrionStatusDesciption())) {
			return false;
		}

		refReservationStatusDAO.addRefReservationStatus(refReservationStatus);
		return true;
	}

	public void updateRefReservationStatus(RefReservationStatus refReservationStatus) {
		refReservationStatusDAO.updateRefReservationStatus(refReservationStatus);
	}

	public void deleteRefReservationStatusById(int id) {
		refReservationStatusDAO.deleteRefReservationStatusById(id);
	}

	public void deleteAllRefReservationStatus() {
		refReservationStatusDAO.deleteAllRefReservationStatus();
	}
}
