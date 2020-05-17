package com.mappings.mappings.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.mappings.Domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findById(Integer id);
	List<User> findByFirstName(String firstName);
	List<User> findByAge(Integer age);
	
	
	
}
