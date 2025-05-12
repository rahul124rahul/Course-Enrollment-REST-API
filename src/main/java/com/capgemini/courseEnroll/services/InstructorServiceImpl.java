package com.capgemini.courseEnroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.courseEnroll.entities.Instructor;
import com.capgemini.courseEnroll.exceptions.InstructorNotFoundException;
import com.capgemini.courseEnroll.repositories.InstructorRepository;

import jakarta.validation.Valid;

@Service
public class InstructorServiceImpl implements InstructorService {
	private InstructorRepository instructorRepo;

	@Autowired
	public InstructorServiceImpl(InstructorRepository instructorRepo) {
		this.instructorRepo = instructorRepo;
	}

	@Override
	public List<Instructor> getAllInstructors() {
		return instructorRepo.findAll();
	}

	@Override
	public Instructor getInstructorById(Long id) {
		return instructorRepo.findById(id)
				.orElseThrow(() -> new InstructorNotFoundException("Get : Instructor not found with ID: " + id));
	}

	@Override
	public Instructor saveInstructor(@Valid Instructor instructor) {
		return instructorRepo.save(instructor);
	}

	@Override
	public Instructor updateInstructor(Long id,@Valid  Instructor updatedInstructor) {
		Instructor instructor = instructorRepo.findById(id).orElseThrow(()->new InstructorNotFoundException("Update: Instructor not found with ID: " + id));
		instructor.setName(updatedInstructor.getName());
		instructor.setExpertise(updatedInstructor.getExpertise());
		return instructorRepo.save(instructor);
	}
	
	@Override
	public Instructor patchInstructor(Long id, Instructor patch) {
		Instructor existing = instructorRepo.findById(id)
				.orElseThrow(() -> new InstructorNotFoundException("Patch : instructor not found with ID: " + id));

		if (patch.getName() != null) {
			existing.setName(patch.getName());
		}
		if (patch.getExpertise() != null) {
			existing.setExpertise(patch.getExpertise());
		}
		return instructorRepo.save(existing);
	}

	@Override
	public void deleteInstructor(Long id) {
		if(!instructorRepo.existsById(id)) {
			throw new InstructorNotFoundException("Delete :  Instructor not found with ID: " + id);
		}
		
		Instructor instructor = getInstructorById(id);

		instructorRepo.delete(instructor);
	}
}
