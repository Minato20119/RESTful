/**
 * 
 */
package com.minato.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entityRef.RefClasses;
import com.minato.springboot.interfaceDao.IRefClassesDAO;

/**
 * @author Minato
 *
 */
@Service
public class RefClassesService {

	@Autowired
	private IRefClassesDAO refClassesDAO;

	public List<RefClasses> getAllRefClasses() {
		return refClassesDAO.getAllRefClasses();
	}

	public RefClasses getRefClassesById(int id) {
		RefClasses refClasses = refClassesDAO.getRefClassesById(id);
		return refClasses;
	}

	public synchronized boolean addRefClasses(RefClasses refClasses) {
		if (refClassesDAO.refClasssesExists(refClasses.getClassNumberDescription())) {
			return false;
		}
		refClassesDAO.addRefClasses(refClasses);
		return true;
	}

	public void updateRefClasses(RefClasses refClasses) {
		refClassesDAO.updateRefClasses(refClasses);
	}

	public void deleteRefClasses(int id) {
		refClassesDAO.deleteRefClasses(id);
	}

	public void deleteAllRefClasses() {
		refClassesDAO.deleteAllRefClasses();
	}
}
