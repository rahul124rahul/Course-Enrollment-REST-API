package com.capgemini.courseEnroll.services;

import java.util.List;

import com.capgemini.courseEnroll.dto.CourseDetailsDTO;
import com.capgemini.courseEnroll.dto.EnrolledCourseDTO;
import com.capgemini.courseEnroll.entities.Course;

public interface CourseServise {

	List<Course> getAllCourses();

	Course getCourseById(Long id);

	Course saveCourse(Course courses);

	Course updateCourse(Long id, Course courses);

	Course patchCourse(Long id, Course courses);

	void deleteCourse(Long id);
	
	List<CourseDetailsDTO> getCoursesNotEnrolledByStudent(Long studentId);
	
	List<EnrolledCourseDTO> getCoursesEnrolledByStudent(Long studentId);

	List<CourseDetailsDTO> getCoursesWithInstructorName();
}