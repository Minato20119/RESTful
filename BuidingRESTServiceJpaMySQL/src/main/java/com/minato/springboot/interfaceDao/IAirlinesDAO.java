/**
 * 
 */
package com.minato.springboot.interfaceDao;

import java.util.List;

import com.minato.springboot.entity.Airlines;

/**
 * @author Minato
 *
 */
public interface IAirlinesDAO {

	List<Airlines> getAllAirlines();

	Airlines getAirlinesById(int id);

	void addAirlines(Airlines airlines);

	void updateAirlines(Airlines airlines);

	void deleteAirlines(int id);

	void deleteAllAirlines();

	boolean airlinesExists(String name);

}
