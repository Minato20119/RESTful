/**
 * 
 */
package com.minato.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entityRef.RefClasses;
import com.minato.springboot.interfaceDao.IRefClassesDAO;
import com.minato.springboot.intf.RefClasssesJPARepository;

/**
 * @author Minato
 *
 */
@Transactional
@Repository
public class RefClassesDAO implements IRefClassesDAO {

	@Autowired
	private RefClasssesJPARepository refClasssesJPARepository;

	@Override
	public List<RefClasses> getAllRefClasses() {
		// TODO Auto-generated method stub
		return refClasssesJPARepository.findAll();
	}

	@Override
	public RefClasses getRefClassesById(int id) {
		// TODO Auto-generated method stub
		return refClasssesJPARepository.findOne(id);
	}

	@Override
	public void addRefClasses(RefClasses refClasses) {
		// TODO Auto-generated method stub
		refClasssesJPARepository.save(refClasses);
	}

	@Override
	public void updateRefClasses(RefClasses refClasses) {
		// TODO Auto-generated method stub
		RefClasses rf = getRefClassesById(refClasses.getClassNumber());
		rf.setClassNumberDescription(refClasses.getClassNumberDescription());
		refClasssesJPARepository.flush();
	}

	@Override
	public void deleteRefClasses(int id) {
		// TODO Auto-generated method stub
		refClasssesJPARepository.delete(id);
	}

	@Override
	public void deleteAllRefClasses() {
		// TODO Auto-generated method stub
		refClasssesJPARepository.deleteAll();
	}

	@Override
	public boolean refClasssesExists(String name) {
		// TODO Auto-generated method stub
		return refClasssesJPARepository.findByClassNumberDescription(name) != null ? true : false;
	}

}
