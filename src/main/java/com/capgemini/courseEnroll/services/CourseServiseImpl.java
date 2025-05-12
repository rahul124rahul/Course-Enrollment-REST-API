package com.capgemini.courseEnroll.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.courseEnroll.dto.CourseDetailsDTO;
import com.capgemini.courseEnroll.dto.EnrolledCourseDTO;
import com.capgemini.courseEnroll.entities.Course;
import com.capgemini.courseEnroll.exceptions.CourseNotFoundException;
import com.capgemini.courseEnroll.repositories.CoursesRepository;

import jakarta.validation.Valid;

@Service
public class CourseServiseImpl implements CourseServise {
	private final CoursesRepository coursesRepo;

	@Autowired
	public CourseServiseImpl(CoursesRepository coursesRepo) {
		this.coursesRepo = coursesRepo;
	}

	@Override
	public List<Course> getAllCourses() {
		return coursesRepo.findAll();
	}
	
	

	@Override
	public Course getCourseById(Long id) {
		return coursesRepo.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Get : Course not found with ID: " + id));
	}

	@Override
	public Course saveCourse(@Valid Course course) {
		return coursesRepo.save(course);
	}

	@Override
	public Course updateCourse(Long id, @Valid Course updatedCourse) {
		Course Course = coursesRepo.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Update : Course not found with ID: " + id));
		Course.setTitle(updatedCourse.getTitle());
		Course.setDescription(updatedCourse.getDescription());
		Course.setInstructorId(updatedCourse.getInstructorId());
		Course.setFee(updatedCourse.getFee());
		return coursesRepo.save(Course);
	}

	@Override
	public Course patchCourse(Long id, Course patch) {
		Course existing = coursesRepo.findById(id)
				.orElseThrow(() -> new CourseNotFoundException("Patch : Course not found with ID: " + id));

		if (patch.getTitle() != null) {
			existing.setTitle(patch.getTitle());
		}
		if (patch.getDescription() != null) {
			existing.setDescription(patch.getDescription());
		}
		if (patch.getInstructorId() != 0) {
			existing.setInstructorId(patch.getInstructorId());
		}
		if (patch.getFee() != 0) {
			existing.setFee(patch.getFee());
		}
		return coursesRepo.save(existing);
	}

	@Override
	public void deleteCourse(Long id) {
		if (!coursesRepo.existsById(id)) {
			throw new CourseNotFoundException("Cannot delete. Course not found with ID: " + id);
		}
		coursesRepo.deleteById(id);
	}
	
	@Override
	public List<CourseDetailsDTO> getCoursesNotEnrolledByStudent(Long studentId) {
		// TODO Auto-generated method stub
		List<Object[]> results = coursesRepo.findCourseDetailsNotEnrolledByStudent(studentId);

        return results.stream()
            .map(obj -> new CourseDetailsDTO(
                (Long)obj[0],
                (String) obj[1],
                (String) obj[2],
                (Double) obj[3],
                (String) obj[4]
            )).collect(Collectors.toList());
	}
	
	
	@Override
	public List<EnrolledCourseDTO> getCoursesEnrolledByStudent(Long studentId) {
		// TODO Auto-generated method stub
		List<Object[]> results = coursesRepo.findCourseDetailsEnrolledByStudent(studentId);
		
		return results.stream()
	            .map(obj -> new EnrolledCourseDTO(
	            	(Long)obj[0],
	                (Long)obj[1],
	                (String) obj[2],
	                (String) obj[3],
	                (Double) obj[4],
	                (String) obj[5]
	            )).collect(Collectors.toList());
	}
	
	@Override
	public List<CourseDetailsDTO> getCoursesWithInstructorName() {
		List<Object[]> results = coursesRepo.findCoursesWithInstructorName();

        return results.stream()
            .map(obj -> new CourseDetailsDTO(
                (Long)obj[0],
                (String) obj[1],
                (String) obj[2],
                (Double) obj[3],
                (String) obj[4],
                (Long)  ((Number) obj[5]).longValue()
            )).collect(Collectors.toList());
	}
	
	
}
