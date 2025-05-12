package com.capgemini.courseEnroll.services;

import java.util.List;

import com.capgemini.courseEnroll.entities.Instructor;

public interface InstructorService {
	List<Instructor> getAllInstructors();

	Instructor getInstructorById(Long id);

	Instructor saveInstructor(Instructor instructor);

	Instructor updateInstructor(Long id, Instructor instructor);

	Instructor patchInstructor(Long id, Instructor instructor);
	
	void deleteInstructor(Long id);
}
