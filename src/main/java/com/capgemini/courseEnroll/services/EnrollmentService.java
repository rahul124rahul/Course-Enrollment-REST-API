package com.capgemini.courseEnroll.services;

import java.util.List;

import com.capgemini.courseEnroll.entities.Enrollment;

public interface EnrollmentService {
	List<Enrollment> getAllEnrollments();

	Enrollment getEnrollmentById(Long id);

	Enrollment createEnrollment(Enrollment enroll);

	Enrollment updateEnrollment(Long id, Enrollment enroll);

	Enrollment patchEnrollment(Long id, Enrollment enroll);

	void deleteEnrollment(Long id);
}
