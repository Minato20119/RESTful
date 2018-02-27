/**
 * 
 */
package com.minato.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minato.springboot.entity.Customers;
import com.minato.springboot.interfaceDao.ICustomersDAO;

/**
 * @author Minato
 *
 */
@Service
public class CustomerService {

	@Autowired
	private ICustomersDAO customersDAO;
	
	public Customers getCustomersById(int id) {
		Customers customers = customersDAO.getCustomersById(id);
		return customers;
	}
	
	public List<Customers> getAllCustomers() {
		return customersDAO.getAllCustomers();
	}
	
	public synchronized boolean addCustomers(Customers customers) {
		if (customersDAO.customersExists(customers.getCustomerName())) {
			return false;
		} else {
			customersDAO.addCustomers(customers);
			return true;
		}
	}
	
	public void updateCustomers(Customers customers) {
		customersDAO.updateCustomers(customers);
	}
	
	public void deleteCustomers(int id ) {
		customersDAO.deleteCustomers(id);
	}
	
	public void deleteAllCustomers() {
		customersDAO.deleteAllCustomers();
	}
}
