package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByFirstName(String firstName);
	List<Student> findByLastName(String lastName);
	List<Student> findByEmail(String email);
	Student findByFirstNameAndLastName(String firstName, String lastName);
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	List<Student> findByFirstNameIn(List<String> firstNames);
}
