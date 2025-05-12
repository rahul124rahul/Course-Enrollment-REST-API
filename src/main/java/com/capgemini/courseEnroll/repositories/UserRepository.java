package com.capgemini.courseEnroll.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.courseEnroll.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
	
	@Query("select u from User u where u.userType = 'Student'")
	List<User> findAllStudents();
	
	User findByEmail(String email);

	
//	Optional<User> findByEmail(String email);
//
//	Optional<User> findByUserNameOrEmail(String username, String email);
	Optional<User> findByNameOrEmail(String username, String email);
//
//	Optional<User> findByUserName(String username);
//
	boolean existsByName(String username);

//	boolean existsByEmail(String email);
}
