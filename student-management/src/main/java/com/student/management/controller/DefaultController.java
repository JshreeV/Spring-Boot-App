package com.student.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jayshree
 */

@Controller
public class DefaultController {

	@GetMapping("/")
	public ModelAndView startupPage()
	{
		System.out.println("inside method controller");
		return new ModelAndView("home");
	}
	
        @GetMapping("/studentInfo")
	public ModelAndView studentPage()
	{
		System.out.println("inside method controller");
		return new ModelAndView("student");
	}
        
        @GetMapping("/courseInfo")
	public ModelAndView coursePage()
	{
		System.out.println("inside method controller");
		return new ModelAndView("courses");
	}
	
}
