package com.capgemini.courseEnroll.services;

import java.util.List;

import com.capgemini.courseEnroll.entities.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(Long id);

	User createUser(User user);

	User updateUser(Long id, User user);

	User patchUser(Long id, User user);

	void deleteUser(Long id);
	
	List<User> getStudentUser();
	
	User loginAsUser(String email,String password);
	
	boolean existsByName(String name);
	boolean existsByEmail(String email);
	User findByNameOrEmail(String name , String email);
}
