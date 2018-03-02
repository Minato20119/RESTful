/**
 * 
 */
package com.minato.springboot.interfaceDao;

import java.util.List;

import com.minato.springboot.entityRef.RefClasses;

/**
 * @author Minato
 *
 */
public interface IRefClassesDAO {

	List<RefClasses> getAllRefClasses();

	RefClasses getRefClassesById(int id);

	void addRefClasses(RefClasses refClasses);

	void updateRefClasses(RefClasses refClasses);

	void deleteRefClasses(int id);

	void deleteAllRefClasses();

	boolean refClasssesExists(String name);
}
