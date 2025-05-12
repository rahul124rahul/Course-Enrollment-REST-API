package com.capgemini.courseEnroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.courseEnroll.entities.Enrollment;
import com.capgemini.courseEnroll.exceptions.EnrollmentNotFoundException;
import com.capgemini.courseEnroll.repositories.EnrollmentRepository;

import jakarta.validation.Valid;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	private final EnrollmentRepository enrollmentRepository;

	@Autowired
	public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
		this.enrollmentRepository = enrollmentRepository;
	}
	
	@Override
	public List<Enrollment> getAllEnrollments() {
		return enrollmentRepository.findAll();
	}

	@Override
	public Enrollment getEnrollmentById(Long id) {
		return enrollmentRepository.findById(id)
				.orElseThrow(() -> new EnrollmentNotFoundException("Get : Enrollment not found with ID: " + id));
	}

	@Override
	public Enrollment createEnrollment(@Valid Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	@Override
	public Enrollment updateEnrollment(Long id, @Valid Enrollment updated) {
		Enrollment existing = enrollmentRepository.findById(id)
				.orElseThrow(() -> new EnrollmentNotFoundException("Update : Enrollment not found with ID: " + id));
		existing.setUserId(updated.getUserId());
		existing.setCourseId(updated.getCourseId());
		existing.setEnrollmentDate(updated.getEnrollmentDate());
		return enrollmentRepository.save(existing);
	}

	@Override
	public Enrollment patchEnrollment(Long id, Enrollment patch) {
		Enrollment existing = enrollmentRepository.findById(id)
				.orElseThrow(() -> new EnrollmentNotFoundException("Patch : Enrollment not found with ID: " + id));

		if (patch.getUserId() != null) {
			existing.setUserId(patch.getUserId());
		}
		if (patch.getCourseId() != null) {
			existing.setCourseId(patch.getCourseId());
		}
		if (patch.getEnrollmentDate() != null) {
			existing.setEnrollmentDate(patch.getEnrollmentDate());
		}
		return enrollmentRepository.save(existing);
	}

	@Override
	public void deleteEnrollment(Long id) {
		if (!enrollmentRepository.existsById(id)) {
			throw new EnrollmentNotFoundException("Cannot delete. Enrollment not found with ID: " + id);
		}
		enrollmentRepository.deleteById(id);
	}
}
