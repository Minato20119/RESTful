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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.minato.springboot.entityRef.RefPaymentMethods;
import com.minato.springboot.service.RefPaymentMethodsService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class RefPaymentMethodsController {

	@Autowired
	private RefPaymentMethodsService refPaymentMethodsService;

	@GetMapping("refPayment/{id}")
	public ResponseEntity<RefPaymentMethods> getRefPaymentMethodsById(@PathVariable("id") int id) {
		RefPaymentMethods refPaymentMethods = refPaymentMethodsService.getRefPaymentMethodsById(id);
		return new ResponseEntity<RefPaymentMethods>(refPaymentMethods, HttpStatus.OK);
	}

	@GetMapping("refPayment")
	public ResponseEntity<List<RefPaymentMethods>> getAllRefPaymentMethods() {
		List<RefPaymentMethods> list = refPaymentMethodsService.getAllRefPaymentMethods();
		return new ResponseEntity<List<RefPaymentMethods>>(list, HttpStatus.OK);
	}

	@PostMapping("refPayment")
	public ResponseEntity<?> addRefPaymentMethods(RefPaymentMethods refPaymentMethods, UriComponentsBuilder builder) {
		boolean flag = refPaymentMethodsService.addRefPaymentMethods(refPaymentMethods);
		if (flag == false)
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("refPayment/{id}").buildAndExpand(refPaymentMethods.getCode()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("refPayment")
	public ResponseEntity<RefPaymentMethods> updateRefPaymentMethods(RefPaymentMethods refPaymentMethods) {
		refPaymentMethodsService.updateRefPaymentMethods(refPaymentMethods);
		return new ResponseEntity<RefPaymentMethods>(HttpStatus.OK);
	}

	@DeleteMapping("refPayment/{id}")
	public ResponseEntity<Void> deleteRefPaymentMethodsById(@PathVariable("id") int id) {
		refPaymentMethodsService.deleteRefPaymentMethodsById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("refPayment")
	public ResponseEntity<Void> deleteAllRefPaymentMethods() {
		refPaymentMethodsService.deleteAllRefPaymentMethods();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
