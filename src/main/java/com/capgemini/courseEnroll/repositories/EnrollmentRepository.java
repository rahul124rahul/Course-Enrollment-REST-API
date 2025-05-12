package com.capgemini.courseEnroll.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.courseEnroll.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	@Query(value = "SELECT c.title, COUNT(e.id) " + "FROM enrollment e " + "JOIN course c ON e.course_id = c.id "
			+ "GROUP BY c.title", nativeQuery = true)
	List<Object[]> courseWiseCount();
	
	@Query(value = """
		    SELECT i.name, count(c.id) AS total_sales
		    FROM enrollment e
		    JOIN course c ON e.course_id = c.id
		    JOIN instructor i ON c.instructor_id = i.id
		    GROUP BY i.name
		""", nativeQuery = true)
		List<Object[]> getInstructorWiseSales();
		
}
