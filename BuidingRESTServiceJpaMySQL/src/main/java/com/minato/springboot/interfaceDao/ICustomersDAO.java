/**
 * 
 */
package com.minato.springboot.interfaceDao;

import java.util.List;

import com.minato.springboot.entity.Customers;

/**
 * @author Minato
 *
 */
public interface ICustomersDAO {

	List<Customers> getAllCustomers();
	Customers getCustomersById(int id);
	void addCustomers(Customers customers);
	void updateCustomers(Customers customers);
	void deleteCustomers(int id);
	void deleteAllCustomers();
	boolean customersExists(String name);
	
}
