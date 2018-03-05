/**
 * 
 */
package com.minato.springboot.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.minato.springboot.entity.Reservations;
import com.minato.springboot.service.CustomerService;
import com.minato.springboot.service.FlightSchedulesService;
import com.minato.springboot.service.RefClassesService;
import com.minato.springboot.service.RefPaymentMethodsService;
import com.minato.springboot.service.RefReservationStatusService;
import com.minato.springboot.service.ReservationsService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class ReservationsController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RefClassesService refClassesService;

	@Autowired
	private ReservationsService reservationsService;

	@Autowired
	private FlightSchedulesService flightSchedulesService;

	@Autowired
	private RefPaymentMethodsService refPaymentMethodsService;

	@Autowired
	private RefReservationStatusService refReservationStatusService;

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

	@PostMapping("reservations")
	public ResponseEntity<?> addReservations(String customerName, String dateReservationMade, String dateOfFlight,
			int eTicketNumber, String otherDetails, int customerId, int schedulesId, int classNumber,
			int paymentMethodCode, int reservationsStatusCode, UriComponentsBuilder builder) throws ParseException {

		if (refClassesService.getRefClassesById(classNumber) == null
				|| customerService.getCustomersById(customerId) == null
				|| flightSchedulesService.getFlightSchedulesById(schedulesId) == null
				|| refPaymentMethodsService.getRefPaymentMethodsById(paymentMethodCode) == null
				|| refReservationStatusService.getRefReservationStatusById(reservationsStatusCode) == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		Reservations reservations = new Reservations(customerName, dateReservationMade, dateOfFlight, eTicketNumber,
				otherDetails, customerService.getCustomersById(customerId),
				flightSchedulesService.getFlightSchedulesById(schedulesId),
				refClassesService.getRefClassesById(classNumber),
				refPaymentMethodsService.getRefPaymentMethodsById(paymentMethodCode),
				refReservationStatusService.getRefReservationStatusById(reservationsStatusCode));

		reservationsService.addReservations(reservations);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("reservations/{id}").buildAndExpand(reservations.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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
