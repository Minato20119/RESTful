/**
 * 
 */
package com.minato.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entityRef.RefPaymentMethods;
import com.minato.springboot.interfaceDao.IRefPaymentMethodsDAO;

/**
 * @author Minato
 *
 */
@Service
public class RefPaymentMethodsService {

	@Autowired
	private IRefPaymentMethodsDAO refPaymentMethodsDAO;

	public List<RefPaymentMethods> getAllRefPaymentMethods() {
		return refPaymentMethodsDAO.getAllRefPaymentMethods();
	}

	public RefPaymentMethods getRefPaymentMethodsById(int id) {
		RefPaymentMethods refPaymentMethods = refPaymentMethodsDAO.getRefPaymentMethodsById(id);
		return refPaymentMethods;
	}

	public synchronized boolean addRefPaymentMethods(RefPaymentMethods refPaymentMethods) {
		if (refPaymentMethodsDAO.refPaymentMethodsExists(refPaymentMethods.getPaymentMethodDescription())) {
			return false;
		}

		refPaymentMethodsDAO.addRefPaymentMethods(refPaymentMethods);
		return true;
	}

	public void updateRefPaymentMethods(RefPaymentMethods refPaymentMethods) {
		refPaymentMethodsDAO.updateRefPaymentMethods(refPaymentMethods);
	}

	public void deleteRefPaymentMethodsById(int id) {
		refPaymentMethodsDAO.deleteRefPaymentMethodsById(id);
	}

	public void deleteAllRefPaymentMethods() {
		refPaymentMethodsDAO.deleteAllRefPaymentMethods();
	}

}
