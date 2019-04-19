package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {
	CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}

}
