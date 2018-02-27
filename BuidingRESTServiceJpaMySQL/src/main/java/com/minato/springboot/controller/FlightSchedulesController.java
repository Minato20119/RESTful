/**
 * 
 */
package com.minato.springboot.controller;

import java.util.Date;
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

import com.minato.springboot.entity.FlightSchedules;
import com.minato.springboot.service.FlightSchedulesService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class FlightSchedulesController {

	@Autowired
	private FlightSchedulesService flightSchedulesService;

	@GetMapping("flightschedules/{id}")
	public ResponseEntity<FlightSchedules> getFlightSchedulesById(@PathVariable("id") Integer id) {
		FlightSchedules flightSchedules = flightSchedulesService.getFlightSchedulesById(id);
		return new ResponseEntity<FlightSchedules>(flightSchedules, HttpStatus.OK);
	}

	@GetMapping("flightschedules")
	public ResponseEntity<List<FlightSchedules>> getAllFlightSchedules() {
		List<FlightSchedules> list = flightSchedulesService.getAllFlightSchedules();
		return new ResponseEntity<List<FlightSchedules>>(list, HttpStatus.OK);
	}

	@PostMapping("flightschedules")
	public ResponseEntity<?> addFlightSchedules(@RequestParam(value = "id") int id,
			@RequestParam(value = "flightNumber") int flightNumber,
			@RequestParam(value = "departureTime") Date departureTime,
			@RequestParam(value = "arrivalTime") Date arrivalTime,
			@RequestParam(value = "otherDetails") String otherDetails, FlightSchedules flightSchedules,
			UriComponentsBuilder builder) {

		// boolean flag = flightSchedulesService.addFlightSchedules(flightSchedules);
		// if (flag == false) {
		// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		// }

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/airlines/{id}").buildAndExpand(flightSchedules.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("flightschedules")
	public ResponseEntity<FlightSchedules> updateFlightSchedules(@RequestBody FlightSchedules flightSchedules) {
		flightSchedulesService.updateFlightSchedules(flightSchedules);
		return new ResponseEntity<FlightSchedules>(flightSchedules, HttpStatus.OK);
	}

	@DeleteMapping("flightschedules/{id}")
	public ResponseEntity<Void> deleteFlightSchedules(@PathVariable("id") Integer id) {
		flightSchedulesService.deleteFlightSchedules(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("flightschedules/all")
	public ResponseEntity<Void> deleteAllFlightScheduless() {
		flightSchedulesService.deleteAllFlightSchedules();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
