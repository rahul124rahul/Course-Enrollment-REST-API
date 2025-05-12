package com.capgemini.courseEnroll.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.courseEnroll.entities.Instructor;
import com.capgemini.courseEnroll.services.InstructorService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("api")
public class InstructorController {

	private final InstructorService service;

	@Autowired
	public InstructorController(InstructorService service) {
		this.service = service;
	}
	
	@GetMapping("/instructors")
	public ResponseEntity<List<Instructor>> getAllInstructors() {
		List<Instructor> instructors = service.getAllInstructors();
		return ResponseEntity.status(HttpStatus.OK).body(instructors);
	}

	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getInstructor(@PathVariable Long id) {
		Instructor instructor = service.getInstructorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(instructor);
	}

	@PostMapping("admin/instructors")
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
		Instructor saved = service.saveInstructor(instructor);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/instructors/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("admin/instructors/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor newIns) {
		Instructor updated = service.updateInstructor(id, newIns);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}
	
	@PatchMapping("admin/instructors/{id}")
		public ResponseEntity<Instructor> patchInstructor(@PathVariable Long id, @RequestBody Instructor patch) {
		Instructor updated = service.patchInstructor(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}



	@DeleteMapping("admin/instructors/{id}")
	public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
		service.deleteInstructor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
