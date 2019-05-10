package com.bjtu.j2ee.sport_club.controller;


import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ResJsonBean.UrlData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class rootController {

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson getCourses()
    {
        UrlData result = new UrlData();
        result.set_links(new UrlData.links());
        result.get_links().setHrefs(new ArrayList<String>());
        result.get_links().getHrefs().add("/user");
        result.get_links().getHrefs().add("/course");

        return result;
    }

}
