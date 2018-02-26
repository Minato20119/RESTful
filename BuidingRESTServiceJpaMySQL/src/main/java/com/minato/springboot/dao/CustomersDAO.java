/**
 * 
 */
package com.minato.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.Customers;
import com.minato.springboot.interfaceDao.ICustomersDAO;
import com.minato.springboot.intf.CustomersJPARepository;

/**
 * @author Minato
 *
 */
@Transactional
@Repository
public class CustomersDAO implements ICustomersDAO {

	@Autowired
	private CustomersJPARepository customersJPARepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.minato.springboot.interfaceDao.ICustomersDAO#getAllCustomers()
	 */
	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return customersJPARepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.minato.springboot.interfaceDao.ICustomersDAO#getCustomersById(long)
	 */
	@Override
	public Customers getCustomersById(int id) {
		// TODO Auto-generated method stub
		return customersJPARepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.minato.springboot.interfaceDao.ICustomersDAO#addCustomers(com.minato.
	 * springboot.entity.Customers)
	 */
	@Override
	public void addCustomers(Customers customers) {
		// TODO Auto-generated method stub
		customersJPARepository.save(customers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.minato.springboot.interfaceDao.ICustomersDAO#updateCustomers(com.minato.
	 * springboot.entity.Customers)
	 */
	@Override
	public void updateCustomers(Customers customers) {
		// TODO Auto-generated method stub
		Customers c = getCustomersById(customers.getId());
		c.setCustomerName(customers.getCustomerName());
		c.setOtherDetails(customers.getOtherDetails());
		customersJPARepository.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.minato.springboot.interfaceDao.ICustomersDAO#deleteCustomers(long)
	 */
	@Override
	public void deleteCustomers(int id) {
		// TODO Auto-generated method stub
		customersJPARepository.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.minato.springboot.interfaceDao.ICustomersDAO#customersExists(java.lang.
	 * String)
	 */
	@Override
	public boolean customersExists(String name) {
		// TODO Auto-generated method stub
		return customersJPARepository.findByCustomerName(name) != null ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.minato.springboot.interfaceDao.ICustomersDAO#deleteAllCustomers()
	 */
	@Override
	public void deleteAllCustomers() {
		// TODO Auto-generated method stub
		customersJPARepository.deleteAll();
	}

}
