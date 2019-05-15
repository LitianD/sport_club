package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;
import com.bjtu.j2ee.sport_club.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "UserController|一个用于用户信息管理的控制器")
public class UserController {
	UserService userServiceTest;

	@Autowired
	void setUserService(UserService userService)
	{
		this.userServiceTest = userService;
	}


	@RequestMapping(value = {"/signup","/signup/"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="用户注册", notes="验证用户注册信息是否合规并返回结果")
	@ApiImplicitParam(paramType="path", name = "reqSignup", value = "用户注册信息Bean", required = true, dataType = "ReqSignup")
	public ResponseJson signUp(@RequestBody ReqSignup reqSignup)
	{

		return userServiceTest.createUser(reqSignup);
	}

	@RequestMapping(value = {"/signin","/signin/"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="用户登录", notes="验证用户登录信息是够正确并返回结果")
	@ApiImplicitParam(paramType="path", name = "reqSignin", value = "用户登录信息Bean", required = true, dataType = "ReqSignin")
	public ResponseJson signIn(@RequestBody ReqSignin reqSignin)
	{
		return userServiceTest.searchUser(reqSignin);
	}


	@RequestMapping(value = {"/update","/update/"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="用户个人信息更新", notes="接受并更改数据库中用户信息")
	@ApiImplicitParam(paramType="path", name = "reqUpdate", value = "用户个人信息Bean", required = true, dataType = "ReqUpdate")
	public ResponseJson update(@RequestBody ReqUpdate reqUpdate)
	{
		return userServiceTest.updateUser(reqUpdate);
	}

}
