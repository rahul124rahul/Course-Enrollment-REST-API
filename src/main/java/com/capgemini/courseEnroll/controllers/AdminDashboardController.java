package com.capgemini.courseEnroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.courseEnroll.dto.AdminDashboardDTO;
import com.capgemini.courseEnroll.entities.AdminDashboardEntity;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/admin/adminDashboard")
public class AdminDashboardController {
	AdminDashboardDTO adminDashboardDTO;

	@Autowired
	public AdminDashboardController(AdminDashboardDTO adminDashboardDTO) {
		super();
		this.adminDashboardDTO = adminDashboardDTO;
	}
	
	@GetMapping
	public ResponseEntity<AdminDashboardEntity> fetchDashboardDetails(){
		return ResponseEntity.status(HttpStatus.OK).body(adminDashboardDTO.adminDashboardEntity());
	}
	
	
}
