package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;
import com.bjtu.j2ee.sport_club.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
	CourseService courseService;

	@Autowired
	public void setCourseService(@RequestBody CourseService courseService)
	{
		this.courseService = courseService;
	}

	@Cacheable(value = "courseList")
	@RequestMapping(value = {"/list/{page}/{size}","/courses/{page}/{size}/"})
	@ResponseBody
	public ResponseJson getCourses(@PathVariable Integer page, @PathVariable Integer size)
	{

		return courseService.getCourseList(page,size);
	}

	@Cacheable(value = "courseInfo", key = "#reqCourse.id")
	@RequestMapping(value = {"/show/{id}","/course/show/{id}/"})
	@ResponseBody
	public ResponseJson getCourseContent (@PathVariable Integer id)
	{

		return courseService.getCourse(id);
	}

	@Cacheable(value = "/user_courses")
	@RequestMapping(value = {"/mycourses","/mycourses/"})
	@ResponseBody
	public ResponseJson getUserCourse(@RequestBody ReqMyCourse reqMyCourse)
	{
		return courseService.getMyCourse(reqMyCourse);
	}

	@Cacheable(value = "/user_add")
	@RequestMapping(value = {"/user_add","/user_add/"})
	@ResponseBody
	public ResponseJson addUserCourse(@RequestBody ReqAddUserCourse reqAddUserCourse)
	{
		return courseService.addUserCourse(reqAddUserCourse);
	}

}