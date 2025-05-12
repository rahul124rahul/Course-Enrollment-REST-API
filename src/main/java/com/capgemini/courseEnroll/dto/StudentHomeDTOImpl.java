package com.capgemini.courseEnroll.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.courseEnroll.entities.StudentHome;
import com.capgemini.courseEnroll.repositories.CoursesRepository;
import com.capgemini.courseEnroll.repositories.EnrollmentRepository;
import com.capgemini.courseEnroll.repositories.InstructorRepository;
import com.capgemini.courseEnroll.repositories.UserRepository;

@Service
public class StudentHomeDTOImpl implements StudentHomeDTO{
	CoursesRepository coursesRepository;
	InstructorRepository instructorRepository;
	UserRepository userRepository;
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	public StudentHomeDTOImpl(CoursesRepository coursesRepository, InstructorRepository instructorRepository,
			UserRepository userRepository, EnrollmentRepository enrollmentRepository) {
		super();
		this.coursesRepository = coursesRepository;
		this.instructorRepository = instructorRepository;
		this.userRepository = userRepository;
		this.enrollmentRepository = enrollmentRepository;
	}
	
	@Override
	public StudentHome getStudentHomeData() {
		// TODO Auto-generated method stub
		StudentHome studentHome = new StudentHome();
		
		studentHome.setFamousCourses(enrollmentRepository.courseWiseCount());
		studentHome.setPopularInstructor(enrollmentRepository.getInstructorWiseSales());
		
		return studentHome;
	}
}
