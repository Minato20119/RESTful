/**
 * 
 */
package com.minato.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minato.springboot.entity.Reservations;
import com.minato.springboot.service.ReservationsService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class ReservationsController {

	@Autowired
	private ReservationsService reservationsService;

	@GetMapping("reservations/{id}")
	public ResponseEntity<Reservations> getReservationsById(@PathVariable("id") Integer id) {
		Reservations reservations = reservationsService.getReservationsById(id);
		return new ResponseEntity<Reservations>(reservations, HttpStatus.OK);
	}

	@GetMapping("reservations")
	public ResponseEntity<List<Reservations>> getAllReservations() {
		List<Reservations> list = reservationsService.getAllReservations();
		return new ResponseEntity<List<Reservations>>(list, HttpStatus.OK);
	}

	@DeleteMapping("reservations/{id}")
	public ResponseEntity<Void> deleteReservations(@PathVariable("id") Integer id) {
		reservationsService.deleteReservationsById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("reservations/all")
	public ResponseEntity<Void> deleteAllReservations() {
		reservationsService.deleteAllReservations();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
