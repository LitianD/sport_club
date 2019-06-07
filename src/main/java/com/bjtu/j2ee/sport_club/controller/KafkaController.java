package com.bjtu.j2ee.sport_club.controller;

import com.bjtu.j2ee.sport_club.ReqJsonBean.ReqAddUserCourse;
import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.service.KafkaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Kafka")
public class KafkaController {

	KafkaService KafkaService;

	@Autowired
	public void setCourseService(@RequestBody KafkaService kafkaService)
	{
		this.KafkaService = kafkaService;
	}



	@RequestMapping(value = {"/user_add","/user_add/"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="用户增加了某课程", notes="返回成功或失败")
	@ApiImplicitParam(paramType="path", name = "reqAddUserCourse", value = "用户订阅的课程信息", required = true, dataType = "ReqAddUserCourse")
	public ResponseJson addUserCourse(@RequestBody ReqAddUserCourse reqAddUserCourse)
	{
		ResponseJson response = new ResponseJson();

		KafkaService.sendGreeting(reqAddUserCourse);
		response.setCode(1);

		return response;
	}

}
