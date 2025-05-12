package com.capgemini.courseEnroll.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.courseEnroll.entities.Course;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Long> {
	@Query(value = "select i.name, Count(c.id) from course c Join instructor i ON c.instructor_id = i.id Group by i.name", nativeQuery = true)
	List<Object[]> instructorWiseCourseCount();

	@Query(value = "select c.id, c.title, c.description, c.fee, i.name AS instructor_name " + "From course c "
			+ "JOIN instructor i ON c.instructor_id = i.id " + "WHERE c.id NOT IN ("
			+ "  Select e.course_id From enrollment e WHERE e.user_id = :userId" + ")", nativeQuery = true)
	List<Object[]> findCourseDetailsNotEnrolledByStudent(@Param("userId") Long studentId);

	@Query(value = "select e.id AS enrollment_id, c.id AS course_id, c.title, c.description, c.fee, i.name As instructor_name "
			+ "from course c " + "JOIN instructor i ON c.instructor_id = i.id "
			+ "join enrollment e On c.id = e.course_id " + "where e.user_id = :userId", nativeQuery = true)
	List<Object[]> findCourseDetailsEnrolledByStudent(@Param("userId") Long studentId);

	@Query(value = "select c.id, c.title, c.description, c.fee, i.name, c.instructor_id "
			+ "from course c join instructor i On c.instructor_id = i.id", nativeQuery = true)
	List<Object[]> findCoursesWithInstructorName();

}