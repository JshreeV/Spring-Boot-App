package com.student.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entity.StudentEntity;
import com.student.management.repository.StudentRepository;

/**
 *
 * @author Jayshree
 */
@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public Integer saveStudent(final String name,final Integer age,final String address,final Integer course_id)
	{
		final StudentEntity studentEntity = new StudentEntity();
		studentEntity.setName(name);
		studentEntity.setAge(age);
		studentEntity.setAddress(address);
                studentEntity.setCourse_id(course_id);
		return repository.save(studentEntity).getId();
	}
	
	
	public List<StudentEntity> getAllStudent()
	{
		return repository.findAll();
	}
	
	public StudentEntity getStudent(final Integer id)
	{
		return repository.findById(id).get();
	}


	public void deleteStudent(Integer id) {
		repository.deleteById(id);
	}
}
