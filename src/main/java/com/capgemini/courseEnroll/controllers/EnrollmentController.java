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

import com.capgemini.courseEnroll.entities.Enrollment;
import com.capgemini.courseEnroll.services.EnrollmentService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api")
public class EnrollmentController {
	private final EnrollmentService service;
	
	@Autowired
	public EnrollmentController(EnrollmentService service) {
		this.service=service;
	}
	
	@GetMapping("admin/enrollments")
	public ResponseEntity<List<Enrollment>> getAllEnrollments() {
		List<Enrollment> enrollments = service.getAllEnrollments();
		return ResponseEntity.status(HttpStatus.OK).body(enrollments);
	}

	@GetMapping("admin/enrollments/{id}")
	public ResponseEntity<Enrollment> getEnrollment(@PathVariable Long id) {
		Enrollment enrollment = service.getEnrollmentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(enrollment);
	}

	@PostMapping("/enrollments")
	public ResponseEntity<Enrollment> createEmployee(@RequestBody Enrollment enrollment) {
		Enrollment saved = service.createEnrollment(enrollment);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/enrollments/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("admin/enrollments/{id}")
	public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment newEnroll) {
		Enrollment updated = service.updateEnrollment(id, newEnroll);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("admin/enrollments/{id}")
	public ResponseEntity<Enrollment> patchEnrollment(@PathVariable Long id, @RequestBody Enrollment patch) {
		Enrollment updated = service.patchEnrollment(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/enrollments/{id}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
		service.deleteEnrollment(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
