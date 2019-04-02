/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.management.repository;

import com.student.management.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jayshree
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    
}
