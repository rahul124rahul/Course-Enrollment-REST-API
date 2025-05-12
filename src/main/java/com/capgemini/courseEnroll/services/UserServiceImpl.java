package com.capgemini.courseEnroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.courseEnroll.entities.User;
import com.capgemini.courseEnroll.exceptions.EmailAlreadyExist;
import com.capgemini.courseEnroll.exceptions.IncorrectPasswordException;
import com.capgemini.courseEnroll.exceptions.UserNotFoundException;
import com.capgemini.courseEnroll.repositories.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Get : User not found with ID : " + id));
	}

	@Override
	public User createUser(@Valid User user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyExist("User with Email : "+user.getEmail()+"Already Exist.");
		}
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, @Valid User user) {
		User existing = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Update : User not found with Id : " + id));
		existing.setName(user.getName());
		existing.setEmail(user.getEmail());
		existing.setPassword(user.getPassword());
		existing.setPhone(user.getPhone());
		existing.setUserType(user.getUserType());

		return userRepository.save(existing);
	}

	@Override
	public User patchUser(Long id, @Valid User patch) {
		User existing = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Patch : User not found with Id : " + id));

		if (patch.getName() != null) {
			existing.setName(patch.getName());
		}
		if (patch.getEmail() != null) {
			existing.setEmail(patch.getEmail());
		}
		if (patch.getPassword() != null) {
			existing.setPassword(patch.getPassword());
		}
		if (patch.getPhone() != null) {
			existing.setPhone(patch.getPhone());
		}
		if (patch.getUserType() != null) {
			existing.setUserType(patch.getUserType());
		}
		return userRepository.save(existing);
	}
	
	@Override
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFoundException("Cannot delete. User not found with ID: " + id);
		}
		userRepository.deleteById(id);
	}
	
	@Override
	public List<User> getStudentUser() {
		// TODO Auto-generated method stub
		return userRepository.findAllStudents();
	}
	
	@Override
	public User loginAsUser(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		if(user==null) {
			throw new UserNotFoundException("Incorrect email : "+email);
		}
		else {
			if(!user.getPassword().equals(password)) {
				throw new IncorrectPasswordException("Incorrect Password");
			}
		}
		return user;
	}
	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);
	}
	
	@Override
	public boolean existsByName(String name) {
		return userRepository.existsByName(name);
	}
	@Override
	public User findByNameOrEmail(String name, String email) {
		return userRepository.findByNameOrEmail(name, email).orElseThrow(()->new UserNotFoundException("Username or Email not Found !"));
	}
}
