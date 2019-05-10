package com.bjtu.j2ee.sport_club.controller;


import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ResJsonBean.UrlData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class rootController {

    @ApiOperation(value="获得/目录下的接口url")
    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson gerRootUrl()
    {
        UrlData result = new UrlData();
        result.set_links(new UrlData.links());
        result.get_links().setHrefs(new ArrayList<String>());
        result.get_links().getHrefs().add("/user");
        result.get_links().getHrefs().add("/course");

        return result;
    }

    @ApiOperation(value="获得/course目录下的接口url")
    @RequestMapping(value = {"/course"},method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson getCourseUrl()
    {
        UrlData result = new UrlData();
        result.set_links(new UrlData.links());
        result.get_links().setHrefs(new ArrayList<String>());
        result.get_links().getHrefs().add("/course/List/0/5");
        result.get_links().getHrefs().add("/course/show/0");
        result.get_links().getHrefs().add("/course/user_courses");
        result.get_links().getHrefs().add("/course/user_add");

        return result;
    }

    @ApiOperation(value="获得/user目录下的接口url")
    @RequestMapping(value = {"/user"},method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson getUserUrl()
    {
        UrlData result = new UrlData();
        result.set_links(new UrlData.links());
        result.get_links().setHrefs(new ArrayList<String>());
        result.get_links().getHrefs().add("/user/signup/");
        result.get_links().getHrefs().add("/user/signin/");
        result.get_links().getHrefs().add("/user/update/");

        return result;
    }
}
