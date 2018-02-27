/**
 * 
 */
package com.minato.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.minato.springboot.entity.Customers;
import com.minato.springboot.service.CustomerService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class CustomersController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("customers/{id}")
	public ResponseEntity<Customers> getCustomersById(@PathVariable("id") Integer id) {
		Customers customers = customerService.getCustomersById(id);
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping("customers")
	public ResponseEntity<List<Customers>> getAllCustomers() {
		List<Customers> list = customerService.getAllCustomers();
		return new ResponseEntity<List<Customers>>(list, HttpStatus.OK);
	}

	@PostMapping("customers")
	public ResponseEntity<?> addCustomers(@RequestParam(value = "id") int id,
			@RequestParam(value = "customerName") String customerName,
			@RequestParam(value = "otherDetails") String otherDetails, Customers customers,
			UriComponentsBuilder builder) {
		customers.setId(id);
		customers.setCustomerName(customerName);
		customers.setOtherDetails(otherDetails);
		boolean flag = customerService.addCustomers(customers);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("customers/{id}").buildAndExpand(customers.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("customers")
	public ResponseEntity<Customers> updateCustomers(@RequestBody Customers customers) {
		customerService.updateCustomers(customers);
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@DeleteMapping("customers/{id}")
	public ResponseEntity<Void> deleteCustomers(@PathVariable("id") Integer id) {
		customerService.deleteCustomers(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("customers/all")
	public ResponseEntity<Void> deleteAllCustomers() {
		customerService.deleteAllCustomers();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
