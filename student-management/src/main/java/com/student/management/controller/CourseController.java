/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.management.controller;

import com.student.management.entity.CourseEntity;
import com.student.management.entity.StudentEntity;
import com.student.management.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jayshree
 */

@RestController
public class CourseController {
    
    @Autowired
    CourseService courseService;
    
    @PostMapping(path= {"/course"},
			produces= {MediaType.ALL_VALUE},
			consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String createCourse(@RequestParam(value="courseName",required=true) String name,@RequestParam("courseDuration") Integer duration)
	{
                
		courseService.saveStudent(name,duration).toString();
		return "student info saved";
	}
	
	@GetMapping(path= {"/course","/course/all"},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<CourseEntity> getAllCourses()
	{
		return courseService.getAllCourses();
	}
	
	@GetMapping(path= {"/course/{courseId}"},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public CourseEntity getStudent(@PathVariable("courseId") Integer id)
	{
		return courseService.getCourse(id);
	}
	
	@DeleteMapping(path = {"/course"},produces= {MediaType.ALL_VALUE})
	public String deleteStudent(@RequestParam(value="courseId",required=true) Integer id)
	{
		courseService.deleteCourse(id);
		return "Course Deleted";
	}
}
