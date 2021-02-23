package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.request.CreateStudentRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;

// @RestController - combines @Controller and @ResponseBody.
@RestController
@RequestMapping("/api/student/")
public class StudentController {

	/*
	 * @Value("${app.name:Default Demo App}") private String appName;
	 * 
	 * @GetMapping("/get") //@RequestMapping(value = "/get", method =
	 * RequestMethod.GET) public StudentResponse getStudent() { return new
	 * StudentResponse(1, "John", "Wayne"); }
	 */

	@Autowired
	StudentService studentService;

	@GetMapping("/getAll")
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}
	
	@GetMapping("getAllWithPagination")
	  public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNum,
			  @RequestParam  int PageSize) {
		  List<Student> studentList = studentService.getAllStudentsWithPagination(pageNum, PageSize);
		  List<StudentResponse> studentResponseList = new ArrayList<>();
		  
		  studentList.stream().forEach(student -> {
			  studentResponseList.add(new StudentResponse(student));
		  });
	  
		  return studentResponseList;
	  }

	@PostMapping("create")
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		Student student = studentService.createStudent(createStudentRequest);

		return new StudentResponse(student);
	}

	@PutMapping("update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student student = studentService.updateStudent(updateStudentRequest);

		return new StudentResponse(student);
	}

	/*
	 * // Delete method using @RequestParam
	 * 
	 * @DeleteMapping("delete") public String deleteStudent(@RequestParam long id) {
	 * return studentService.deleteStudent(id); }
	 */

	// Delete method using @PathVariable
	@DeleteMapping("delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("getByFirstName/{firstName}")
	public List<StudentResponse> getByFirstName(@PathVariable String firstName) {
		List<Student> studentList = studentService.getByFirstName(firstName);
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}
	
	
	  // To-do: Implement these.
	  
	  @GetMapping("getByLastName/{lastName}")
	  public List<StudentResponse> getByLastName(@PathVariable String lastName) {
		  List<Student> studentList = studentService.getByLastName(lastName);
		  List<StudentResponse> studentResponseList = new ArrayList<>();
	  
		  studentList.stream().forEach(student -> {
			  studentResponseList.add(new StudentResponse(student));
		  });
	  
		  return studentResponseList;
	  }
	  
	  @GetMapping("getByEmail/{email}")
	  public List<StudentResponse> getByEmail(@PathVariable String email) {
		  List<Student> studentList = studentService.getByEmail(email);
		  List<StudentResponse> studentResponseList = new ArrayList<>();
	  
		  studentList.stream().forEach(student -> {
			  studentResponseList.add(new StudentResponse(student));
		  });
	  
		  return studentResponseList;
	  }
	  
	  @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
	  public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName, 
			  @PathVariable String lastName) {
		  Student student = studentService.getByFirstNameAndLastName(firstName, lastName);
		  
		  return new StudentResponse(student);
	  }
	  
	  @GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
	  public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName, 
			  @PathVariable String lastName) {
		  List<Student> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);
		  List<StudentResponse> studentResponseList = new ArrayList<>();
		  
		  studentList.stream().forEach(student -> {
			  studentResponseList.add(new StudentResponse(student));
		  });
	  
		  return studentResponseList;
	  }
	  
	  @GetMapping("getByFirstNameIn")
	  public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest) {
		  List<Student> studentList = studentService.getByFirstNameIn(inQueryRequest);
		  List<StudentResponse> studentResponseList = new ArrayList<>();
		  
		  studentList.stream().forEach(student -> {
			  studentResponseList.add(new StudentResponse(student));
		  });
	  
		  return studentResponseList;
	  }

}
