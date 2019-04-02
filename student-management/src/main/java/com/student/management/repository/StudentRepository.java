package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jayshree
 */

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    
}
