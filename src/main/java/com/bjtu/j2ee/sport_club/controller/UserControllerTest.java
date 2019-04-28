package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;
import com.bjtu.j2ee.sport_club.service.UserServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControllerTest {
	UserServiceTest userServiceTest;

	@Autowired
	void setUserService(UserServiceTest userService)
	{
		this.userServiceTest = userService;
	}


	@RequestMapping(value = {"/signup","/signup/"})
	@ResponseBody
	public ResponseJson signUp(@RequestBody ReqSignup reqSignup)
	{

		return userServiceTest.createUser(reqSignup);
	}

	@RequestMapping(value = {"/signin","/signin/"})
	@ResponseBody
	public ResponseJson signIn(@RequestBody ReqSignin reqSignin)
	{
		return userServiceTest.searchUser(reqSignin);
	}


	@RequestMapping(value = {"/update","/update/"})
	@ResponseBody
	public ResponseJson update(@RequestBody ReqUpdate reqUpdate)
	{
		return userServiceTest.updateUser(reqUpdate);
	}

}
