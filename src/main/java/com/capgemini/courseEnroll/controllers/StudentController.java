package com.capgemini.courseEnroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.courseEnroll.dto.StudentHomeDTO;
import com.capgemini.courseEnroll.entities.StudentHome;
import com.capgemini.courseEnroll.services.UserService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api")

public class StudentController {
	StudentHomeDTO studentHomeDTO;
	UserService userService;

	@Autowired
	public StudentController(StudentHomeDTO studentHomeDTO) {
		super();
		this.studentHomeDTO = studentHomeDTO;
	}

	@GetMapping("/home")
//	@PreAuthorize("hasRole('Student')")
	public ResponseEntity<StudentHome> fetchHomeDetails() {
		return ResponseEntity.status(HttpStatus.OK).body(studentHomeDTO.getStudentHomeData());
	}

}
