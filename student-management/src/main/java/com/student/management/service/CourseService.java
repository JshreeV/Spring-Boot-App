/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.management.service;

import com.student.management.entity.CourseEntity;
import com.student.management.entity.StudentEntity;
import com.student.management.repository.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jayshree
 */
@Service
public class CourseService {
        @Autowired
	private CourseRepository repository;
	
	public Integer saveStudent(final String name, final Integer duration)
	{
		final CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourse_name(name);
                courseEntity.setCourse_duration(duration);
                return repository.save(courseEntity).getCourse_id();
	}
	
	
	public List<CourseEntity> getAllCourses()
	{
		return repository.findAll();
	}
	
	public CourseEntity getCourse(final Integer id)
	{
		return repository.findById(id).get();
	}


	public void deleteCourse(Integer id) {
		repository.deleteById(id);
	}
}
