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

import com.minato.springboot.entityRef.RefReservationStatus;
import com.minato.springboot.service.RefReservationStatusService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class RefReservationStatusController {

	@Autowired
	private RefReservationStatusService refReservationStatusService;

	@GetMapping("refReservation/{id}")
	public ResponseEntity<RefReservationStatus> getRefReservationStatusById(@PathVariable("id") int id) {
		RefReservationStatus refReservationStatus = refReservationStatusService.getRefReservationStatusById(id);
		return new ResponseEntity<RefReservationStatus>(refReservationStatus, HttpStatus.OK);
	}

	@GetMapping("refReservation")
	public ResponseEntity<List<RefReservationStatus>> getAllRefReservationStatus() {
		List<RefReservationStatus> list = refReservationStatusService.getAllRefReservationStatus();
		return new ResponseEntity<List<RefReservationStatus>>(list, HttpStatus.OK);
	}

	@PostMapping("refReservation")
	public ResponseEntity<?> addRefReservationStatus(RefReservationStatus refReservationStatus,
			UriComponentsBuilder builder) {
		boolean flag = refReservationStatusService.addRefReservationStatus(refReservationStatus);
		if (flag == false)
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("refReservation/{id}").buildAndExpand(refReservationStatus.getCode()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("refReservation")
	public ResponseEntity<RefReservationStatus> updateRefReservationStatus(RefReservationStatus refReservationStatus) {
		refReservationStatusService.updateRefReservationStatus(refReservationStatus);
		return new ResponseEntity<RefReservationStatus>(HttpStatus.OK);
	}

	@DeleteMapping("refReservation/{id}")
	public ResponseEntity<Void> deleteRefReservationStatusById(@PathVariable("id") int id) {
		refReservationStatusService.deleteRefReservationStatusById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("refReservation")
	public ResponseEntity<Void> deleteAllRefReservationStatus() {
		refReservationStatusService.deleteAllRefReservationStatus();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
