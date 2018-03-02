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

import com.minato.springboot.entity.Airlines;
import com.minato.springboot.service.AirlinesService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class AirlinesController {

	@Autowired
	private AirlinesService airlinesService;

	@GetMapping("airlines/{id}")
	public ResponseEntity<Airlines> getAirlinesById(@PathVariable("id") Integer id) {
		Airlines airlines = airlinesService.getAirlinesById(id);
		return new ResponseEntity<Airlines>(airlines, HttpStatus.OK);
	}

	@GetMapping("airlines")
	public ResponseEntity<List<Airlines>> getAllAirlines() {
		List<Airlines> list = airlinesService.getAllAirlines();
		return new ResponseEntity<List<Airlines>>(list, HttpStatus.OK);
	}

	@PostMapping("airlines")
	public ResponseEntity<?> addAirlines(Airlines airlines, UriComponentsBuilder builder) {

		System.out.println("Before Code: " + airlines.getCode());
		System.out.println("Name: " + airlines.getName());
		System.out.println("Details: " + airlines.getOtherDetails());

		boolean flag = airlinesService.addAirlines(airlines);
		
		System.out.println("After Code: " + airlines.getCode());
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/airlines/{id}").buildAndExpand(airlines.getCode()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("airlines")
	public ResponseEntity<Airlines> updateAirlines(Airlines airlines) {
		airlinesService.updateAirlines(airlines);
		return new ResponseEntity<Airlines>(airlines, HttpStatus.OK);
	}

	@DeleteMapping("airlines/{id}")
	public ResponseEntity<Void> deleteAirlines(@PathVariable("id") Integer id) {
		airlinesService.deleteAirlines(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("airlines/all")
	public ResponseEntity<Void> deleteAllAirlines() {
		airlinesService.deleteAllAirlines();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
