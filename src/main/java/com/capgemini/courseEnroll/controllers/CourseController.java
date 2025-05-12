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

import com.capgemini.courseEnroll.dto.CourseDetailsDTO;
import com.capgemini.courseEnroll.dto.EnrolledCourseDTO;
import com.capgemini.courseEnroll.entities.Course;
import com.capgemini.courseEnroll.services.CourseServise;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api")
public class CourseController {
	private final CourseServise courseService;

	@Autowired
	public CourseController(CourseServise courseService) {
		this.courseService = courseService;
	}

	@GetMapping("admin/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		return ResponseEntity.status(HttpStatus.OK).body(courses);
	}
	
	@GetMapping("student/courses")
	public ResponseEntity<List<Course>> getAllCourses2() {
		List<Course> courses = courseService.getAllCourses();
		return ResponseEntity.status(HttpStatus.OK).body(courses);
	}

	@GetMapping("admin/courses/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Long id) {
		Course course = courseService.getCourseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(course);
	}

	@PostMapping("admin/courses")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course saved = courseService.saveCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@PutMapping("admin/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course newCourse) {
		Course updated = courseService.updateCourse(id, newCourse);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("admin/courses/{id}")
	public ResponseEntity<Course> patchCourse(@PathVariable Long id, @RequestBody Course patch) {
		Course updated = courseService.patchCourse(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("admin/courses/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@GetMapping("/student/courses/notenrolled/{studentId}")
    public ResponseEntity<List<CourseDetailsDTO>> getNotEnrolledCourses(@PathVariable Long studentId) {
        List<CourseDetailsDTO> courses = courseService.getCoursesNotEnrolledByStudent(studentId);
        return ResponseEntity.ok(courses);
    }
	
	
	@GetMapping("/student/courses/enrolled/{studentId}")
    public ResponseEntity<List<EnrolledCourseDTO>> getEnrolledCourses(@PathVariable Long studentId) {
        List<EnrolledCourseDTO> courses = courseService.getCoursesEnrolledByStudent(studentId);
        return ResponseEntity.ok(courses);
    }
	
	@GetMapping("/admin/coursesAccess")
    public ResponseEntity<List<CourseDetailsDTO>> getCourses() {
        List<CourseDetailsDTO> courses = courseService.getCoursesWithInstructorName();
        return ResponseEntity.ok(courses);
    }
}
