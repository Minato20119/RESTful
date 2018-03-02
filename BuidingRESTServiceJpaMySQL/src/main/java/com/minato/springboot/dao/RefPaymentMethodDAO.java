/**
 * 
 */
package com.minato.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entityRef.RefPaymentMethods;
import com.minato.springboot.interfaceDao.IRefPaymentMethodsDAO;
import com.minato.springboot.intf.RefPaymentMethodsJPARepository;

/**
 * @author Minato
 *
 */
@Transactional
@Repository
public class RefPaymentMethodDAO implements IRefPaymentMethodsDAO {

	@Autowired
	private RefPaymentMethodsJPARepository refPaymentMethodsJPARepository;

	@Override
	public List<RefPaymentMethods> getAllRefPaymentMethods() {
		// TODO Auto-generated method stub
		return refPaymentMethodsJPARepository.findAll();
	}

	@Override
	public RefPaymentMethods getRefPaymentMethodsById(int id) {
		// TODO Auto-generated method stub
		return refPaymentMethodsJPARepository.findOne(id);
	}

	@Override
	public void addRefPaymentMethods(RefPaymentMethods refPaymentMethods) {
		// TODO Auto-generated method stub
		refPaymentMethodsJPARepository.save(refPaymentMethods);
	}

	@Override
	public void updateRefPaymentMethods(RefPaymentMethods refPaymentMethods) {
		// TODO Auto-generated method stub
		RefPaymentMethods rp = getRefPaymentMethodsById(refPaymentMethods.getCode());
		rp.setPaymentMethodDescription(refPaymentMethods.getPaymentMethodDescription());
		refPaymentMethodsJPARepository.flush();
	}

	@Override
	public void deleteRefPaymentMethods(int id) {
		// TODO Auto-generated method stub
		refPaymentMethodsJPARepository.delete(id);
	}

	@Override
	public void deleteAllRefPaymentMethods() {
		// TODO Auto-generated method stub
		refPaymentMethodsJPARepository.deleteAll();
	}

	@Override
	public boolean refPaymentMethodsExists(String name) {
		// TODO Auto-generated method stub
		return refPaymentMethodsJPARepository.findByPaymentMethodDescription(name) != null ? true : false;
	}
}
