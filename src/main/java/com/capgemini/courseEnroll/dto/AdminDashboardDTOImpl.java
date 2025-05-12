package com.capgemini.courseEnroll.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.courseEnroll.entities.AdminDashboardEntity;
import com.capgemini.courseEnroll.repositories.CoursesRepository;
import com.capgemini.courseEnroll.repositories.EnrollmentRepository;
import com.capgemini.courseEnroll.repositories.InstructorRepository;
import com.capgemini.courseEnroll.repositories.UserRepository;

@Service
public class AdminDashboardDTOImpl implements AdminDashboardDTO{
	CoursesRepository coursesRepository;
	InstructorRepository instructorRepository;
	UserRepository userRepository;
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	public AdminDashboardDTOImpl(CoursesRepository coursesRepository, InstructorRepository instructorRepository,
			UserRepository userRepository, EnrollmentRepository enrollmentRepository) {
		super();
		this.coursesRepository = coursesRepository;
		this.instructorRepository = instructorRepository;
		this.userRepository = userRepository;
		this.enrollmentRepository = enrollmentRepository;
	}
	
	@Override
	public AdminDashboardEntity adminDashboardEntity() {
		// TODO Auto-generated method stub
		
		AdminDashboardEntity adminDashboardEntity = new AdminDashboardEntity();
		adminDashboardEntity.setCoursesCount(coursesRepository.findAll().size());
		adminDashboardEntity.setEnrollmentCount(enrollmentRepository.findAll().size());
		adminDashboardEntity.setInstructorCount(instructorRepository.findAll().size());
		adminDashboardEntity.setStudentCount(userRepository.findAllStudents().size());
		
		adminDashboardEntity.setCourseSales(enrollmentRepository.courseWiseCount());
		adminDashboardEntity.setInstructorWiseCourses(coursesRepository.instructorWiseCourseCount());
		adminDashboardEntity.setInstructorWiseCourseSale(enrollmentRepository.getInstructorWiseSales());
		
		return adminDashboardEntity;
	}
	
}
