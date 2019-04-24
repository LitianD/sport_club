package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.bean.*;
import com.bjtu.j2ee.sport_club.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {
	CourseService courseService;

	@Autowired
	public void setCourseService(@RequestBody CourseService courseService)
	{
		this.courseService = courseService;
	}

	@Cacheable(value = "courseList")
	@RequestMapping(value = {"/courses","/courses/"})
	@ResponseBody
	public ResCourseList getCourses()
	{
		ResCourseList resCourseList;
		resCourseList = courseService.getCourseList(1,3);
		return resCourseList;
	}

	@Cacheable(value = "courseInfo", key = "#reqCourse.id")
	@RequestMapping(value = {"/coursecontent","/coursecontent/"})
	@ResponseBody
	public ResCourse getCourse(@RequestBody ReqCourse reqCourse)
	{
		ResCourse resCourse;
		resCourse = courseService.getCourse(reqCourse);
		return resCourse;
	}

	@Cacheable(value = "userCourseList", key = "#reqMyCourse.id")
	@RequestMapping(value = {"/mycourses","/mycourses/"})
	@ResponseBody
	public ResMyCourse getMyCourse(@RequestBody ReqMyCourse reqMyCourse)
	{
		ResMyCourse resMyCourse;
		resMyCourse = courseService.getMyCourse(reqMyCourse);
		return resMyCourse;
	}

	@Cacheable(value = "coachList")
	@RequestMapping(value = {"/coaches","/coaches/"})
	@ResponseBody
	public ResCoach getCouaches(@RequestBody ReqCoach reqCoach)
	{
		ResCoach resCoach;
		resCoach = courseService.getCoach(reqCoach);
		return resCoach;
	}
}
