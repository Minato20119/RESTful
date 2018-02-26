/**
 * 
 */
package com.minato.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entity.Airlines;
import com.minato.springboot.interfaceDao.IAirlinesDAO;

/**
 * @author Minato
 *
 */
@Service
public class AirlinesService {

	@Autowired
	private IAirlinesDAO airlinesDAO;
	
	public Airlines getAirlinesById(int id) {
		Airlines airlines = airlinesDAO.getAirlinesById(id);
		return airlines;
	}
	
	public List<Airlines> getAllAirlines() {
		return airlinesDAO.getAllAirlines();
	}
	
	public synchronized boolean addAirlines(Airlines airlines) {
		if (airlinesDAO.airlinesExists(airlines.getName())) {
			return false;
		} else {
			airlinesDAO.addAirlines(airlines);
			return true;
		}
	}
	
	public void updateAirlines(Airlines airlines) {
		airlinesDAO.updateAirlines(airlines);
	}
	
	public void deleteAirlines(int id ) {
		airlinesDAO.deleteAirlines(id);
	}
	
	public void deleteAllAirlines() {
		airlinesDAO.deleteAllAirlines();
	}
}
