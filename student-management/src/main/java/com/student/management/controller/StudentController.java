package com.student.management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entity.StudentEntity;
import com.student.management.service.StudentService;

/**
 *
 * @author Jayshree
 */

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(path= {"/student"},
			produces= {MediaType.ALL_VALUE},
			consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String createStudent(@RequestParam(value="studentName",required=true) String name,
								@RequestParam("studentAge") Integer age,
								@RequestParam("studentAddress") String address,
                                                                @RequestParam("courseId") Integer course_id)
	{
		service.saveStudent(name, age, address,course_id).toString();
		return "student info saved";
	}
	
	@GetMapping(path= {"/student","/student/all"},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<StudentEntity> getAllStudent()
	{
		return service.getAllStudent();
	}
	
	@GetMapping(path= {"/student/{studentId}"},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public StudentEntity getStudent(@PathVariable("studentId") Integer id)
	{
		return service.getStudent(id); 
	}
	
	@DeleteMapping(path = {"/student"},produces= {MediaType.ALL_VALUE})
	public String deleteStudent(@RequestParam(value="studentId",required=true) Integer id)
	{
		service.deleteStudent(id);
		return "Student Deleted";
	}

}
