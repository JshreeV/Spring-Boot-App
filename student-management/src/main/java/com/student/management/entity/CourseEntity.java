/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Jayshree
 */
@Entity(name="course")
@Table(name="course")
public class CourseEntity {
        @Id
	@GenericGenerator(name="courseIdGenerator",strategy="increment")
	@GeneratedValue(generator="courseIdGenerator")
        @Column(name="course_id")
	private Integer course_id;
	
	@Column(name="course_name")
	private String course_name;
        
        @Column(name="course_duration")
	private Integer course_duration;

    public CourseEntity(){
        
    }

    /**
     * @return the course_name
     */
    public String getCourse_name() {
        return course_name;
    }

    /**
     * @param course_name the course_name to set
     */
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    /**
     * @return the course_id
     */
    public Integer getCourse_id() {
        return course_id;
    }

    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    /**
     * @return the course_duration
     */
    public Integer getCourse_duration() {
        return course_duration;
    }

    /**
     * @param course_duration the course_duration to set
     */
    public void setCourse_duration(Integer course_duration) {
        this.course_duration = course_duration;
    }
	
        
}
