package com.capgemini.courseEnroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.courseEnroll.entities.Instructor;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
	
}
