/**
 * 
 */
package com.minato.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entityRef.RefReservationStatus;
import com.minato.springboot.interfaceDao.IRefReservationStatusDAO;
import com.minato.springboot.intf.RefReservationStatusJPARepository;

/**
 * @author Minato
 *
 */
@Transactional
@Repository
public class RefReservationStatusDAO implements IRefReservationStatusDAO {

	@Autowired
	private RefReservationStatusJPARepository refReservationStatusJPARepository;

	@Override
	public List<RefReservationStatus> getAllRefReservationStatus() {
		// TODO Auto-generated method stub
		return refReservationStatusJPARepository.findAll();
	}

	@Override
	public RefReservationStatus getRefReservationStatusById(int id) {
		// TODO Auto-generated method stub
		return refReservationStatusJPARepository.findOne(id);
	}

	@Override
	public void addRefReservationStatus(RefReservationStatus refReservationStatus) {
		// TODO Auto-generated method stub
		refReservationStatusJPARepository.save(refReservationStatus);
	}

	@Override
	public void updateRefReservationStatus(RefReservationStatus refReservationStatus) {
		// TODO Auto-generated method stub
		RefReservationStatus rs = getRefReservationStatusById(refReservationStatus.getCode());
		rs.setReservatrionStatusDesciption(refReservationStatus.getReservatrionStatusDesciption());
		refReservationStatusJPARepository.flush();
	}

	@Override
	public void deleteRefReservationStatusById(int id) {
		// TODO Auto-generated method stub
		refReservationStatusJPARepository.delete(id);
	}

	@Override
	public void deleteAllRefReservationStatus() {
		// TODO Auto-generated method stub
		refReservationStatusJPARepository.deleteAll();
	}

	@Override
	public boolean refReservationStatusExists(String name) {
		// TODO Auto-generated method stub
		return refReservationStatusJPARepository.findByReservatrionStatusDesciption(name) != null ? true : false;
	}

}
