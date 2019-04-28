package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;
import com.bjtu.j2ee.sport_club.service.CourseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseControllerTest {
	CourseServiceTest courseService;

	@Autowired
	public void setCourseService(@RequestBody CourseServiceTest courseService)
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

}