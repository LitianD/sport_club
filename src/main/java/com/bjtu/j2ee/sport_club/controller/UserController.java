package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.bean.*;
import com.bjtu.j2ee.sport_club.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	UserService userService;

	@Autowired
	void setUserService(UserService userService)
	{
		this.userService = userService;
	}


	@RequestMapping(value = {"/signup","/signup/"})
	@ResponseBody
	public ResSignup signUp(@RequestBody ReqSignup reqSignup)
	{
		ResSignup resSignup;
		resSignup=userService.createUser(reqSignup);
		return resSignup;
	}

	@RequestMapping(value = {"/signin","/signin/"})
	@ResponseBody
	public ResSignin signIn(@RequestBody ReqSignin reqSignin)
	{
		ResSignin resSignin;
		resSignin = userService.searchUser(reqSignin);
		return resSignin;
	}


	@RequestMapping(value = {"/update","/update/"})
	@ResponseBody
	public ResUpdate update(@RequestBody ReqUpdate reqUpdate)
	{
		ResUpdate resUpdate;
		resUpdate = userService.updateUser(reqUpdate);
		return resUpdate;
	}

}
