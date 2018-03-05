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

import com.minato.springboot.entityRef.RefClasses;
import com.minato.springboot.service.RefClassesService;

/**
 * @author Minato
 *
 */
@Controller
@RequestMapping("entity")
public class RefClassesController {

	@Autowired
	private RefClassesService refClassesService;

	@GetMapping("refClasses/{id}")
	public ResponseEntity<RefClasses> getRefClassesById(@PathVariable("id") int id) {
		RefClasses refClasses = refClassesService.getRefClassesById(id);
		return new ResponseEntity<RefClasses>(refClasses, HttpStatus.OK);
	}

	@GetMapping("refClasses")
	public ResponseEntity<List<RefClasses>> getAllRefClasses() {
		List<RefClasses> list = refClassesService.getAllRefClasses();
		return new ResponseEntity<List<RefClasses>>(list, HttpStatus.OK);
	}

	@PostMapping("refClasses")
	public ResponseEntity<?> addRefClasses(RefClasses refClasses, UriComponentsBuilder builder) {
		boolean flag = refClassesService.addRefClasses(refClasses);
		if (flag == false)
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("refClasses/{id}").buildAndExpand(refClasses.getClassNumber()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("refClasses")
	public ResponseEntity<RefClasses> updateRefClasses(RefClasses refClasses) {
		refClassesService.updateRefClasses(refClasses);
		return new ResponseEntity<RefClasses>(HttpStatus.OK);
	}

	@DeleteMapping("refClasses/{id}")
	public ResponseEntity<Void> deleteRefClassesById(@PathVariable("id") int id) {
		refClassesService.deleteRefClasses(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("refClasses")
	public ResponseEntity<Void> deleteAllRefClasses() {
		refClassesService.deleteAllRefClasses();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
