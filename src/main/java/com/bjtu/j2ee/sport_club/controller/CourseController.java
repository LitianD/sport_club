package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;
import com.bjtu.j2ee.sport_club.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
@Api(value = "CourseController|一个用于课程信息管理的控制器")
public class CourseController {
	CourseService courseService;

	@Autowired
	public void setCourseService(@RequestBody CourseService courseService)
	{
		this.courseService = courseService;
	}

	@Cacheable(value = "courseList")
	@RequestMapping(value = {"/list/{page}/{size}","/courses/{page}/{size}/"},method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="获取课程列表", notes="对返回结果进行分页")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType="path", name = "page", value = "页面数量", required = true, dataType = "Integer"),
			@ApiImplicitParam(paramType="path", name = "size", value = "页面大小", required = true, dataType = "Integer"),
	})
	public ResponseJson getCourses(@PathVariable Integer page, @PathVariable Integer size)
	{

		return courseService.getCourseList(page,size);
	}

	@Cacheable(value = "courseInfo", key = "#id")
	@RequestMapping(value = {"/show/{id}","/course/show/{id}/"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取某个课程内容", notes="仅返回指定课程的内容")
	@ApiImplicitParam(paramType="path", name = "id", value = "课程ID", required = true, dataType = "Integer")
	public ResponseJson getCourseContent (@PathVariable Integer id)
	{

		return courseService.getCourse(id);
	}

	@Cacheable(value = "/user_courses", key = "#reqMyCourse.username")
	@RequestMapping(value = {"/mycourses","/mycourses/"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取指定用户的课程列表", notes="返回用户订阅的所有的课程")
	@ApiImplicitParam(paramType="path", name = "reqMyCourse", value = "用户请求Bean", required = true, dataType = "ReqMyCourse")
	public ResponseJson getUserCourse(@RequestBody ReqMyCourse reqMyCourse)
	{
		return courseService.getMyCourse(reqMyCourse);
	}

	@RequestMapping(value = {"/user_add","/user_add/"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="用户增加了某课程", notes="返回成功或失败")
	@ApiImplicitParam(paramType="path", name = "reqAddUserCourse", value = "用户订阅的课程信息", required = true, dataType = "ReqAddUserCourse")
	public ResponseJson addUserCourse(@RequestBody ReqAddUserCourse reqAddUserCourse)
	{
		return courseService.addUserCourse(reqAddUserCourse);
	}

}