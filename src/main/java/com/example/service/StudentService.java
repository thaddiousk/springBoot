package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.request.CreateStudentRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public List<Student> getAllStudentsWithPagination(int pageNum, int PageSize) {
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
	}
	
	public Student createStudent(CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		
		student = studentRepository.save(student);
		return student;
	}
	
	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
		Student student = studentRepository.findById(updateStudentRequest.getId()).get();
		
		if (updateStudentRequest.getFirstName() != null 
				&& !updateStudentRequest.getFirstName().isEmpty()) {
			student.setFirstName(updateStudentRequest.getFirstName());
		}
		if (updateStudentRequest.getLastName() != null
				&& !updateStudentRequest.getLastName().isEmpty()) {
			student.setLastName(updateStudentRequest.getLastName());
		}
		if (updateStudentRequest.getEmail() != null 
				&& !updateStudentRequest.getEmail().isEmpty()) {
			student.setEmail(updateStudentRequest.getEmail());
		}
		student = studentRepository.save(student);
		return student;
	}
	
	public String deleteStudent(long id) {
		try {
			studentRepository.deleteById(id);
			return "Student has been deleted successfully";
		} catch (IllegalArgumentException ex) {
			return "Student ID is required";
		}
	}
	
	public List<Student> getByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}
	
	public List<Student> getByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}
	
	public List<Student> getByEmail(String email) {
		return studentRepository.findByEmail(email);
	}
	
	public Student getByFirstNameAndLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	
	public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
	}
	
}
