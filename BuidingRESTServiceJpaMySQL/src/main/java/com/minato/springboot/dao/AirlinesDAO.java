/**
 * 
 */
package com.minato.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.Airlines;
import com.minato.springboot.interfaceDao.IAirlinesDAO;
import com.minato.springboot.intf.AirlinesJPARepository;

/**
 * @author Minato
 *
 */
@Transactional
@Repository
public class AirlinesDAO implements IAirlinesDAO {

	@Autowired
	private AirlinesJPARepository airlinesJPARepository;

	@Override
	public List<Airlines> getAllAirlines() {
		// TODO Auto-generated method stub
		return airlinesJPARepository.findAll();
	}

	@Override
	public Airlines getAirlinesById(int id) {
		// TODO Auto-generated method stub
		return airlinesJPARepository.findOne(id);
	}

	@Override
	public void addAirlines(Airlines airlines) {
		// TODO Auto-generated method stub
		airlinesJPARepository.save(airlines);
	}

	@Override
	public void updateAirlines(Airlines airlines) {
		// TODO Auto-generated method stub
		Airlines a = getAirlinesById(airlines.getCode());
		a.setName(airlines.getName());
		a.setOtherDetails(airlines.getOtherDetails());
		airlinesJPARepository.flush();
	}

	@Override
	public void deleteAirlines(int id) {
		// TODO Auto-generated method stub
		airlinesJPARepository.delete(getAirlinesById(id));
	}

	@Override
	public void deleteAllAirlines() {
		// TODO Auto-generated method stub
		airlinesJPARepository.deleteAll();
	}

	@Override
	public boolean airlinesExists(String name) {
		// TODO Auto-generated method stub
		airlinesJPARepository.findByName(name);
		return airlinesJPARepository.findByName(name) != null ? true : false;
	}

}
