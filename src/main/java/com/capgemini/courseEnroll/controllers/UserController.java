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

import com.capgemini.courseEnroll.entities.User;
import com.capgemini.courseEnroll.services.UserService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User enrollment) {
		User saved = userService.createUser(enrollment);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/users/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserRegister(@PathVariable Long id, @RequestBody User newUser) {
		User updated = userService.updateUser(id, newUser);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/users/{id}")
	public ResponseEntity<User> patchUser(@PathVariable Long id, @RequestBody User patch) {
		User updated = userService.patchUser(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/users/students")
	public ResponseEntity<List<User>> getAllStudents() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getStudentUser());
	}

	@PutMapping("/users/students/{id}")
	public ResponseEntity<User> updateStudentRegister(@PathVariable Long id, @RequestBody User newUser) {
		User updated = userService.updateUser(id, newUser);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PostMapping("/users/students")
	public ResponseEntity<User> createStudent(@RequestBody User enrollment) {
		User saved = userService.createUser(enrollment);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/users/" + saved.getId()))
				.body(saved);
	}

	
}
