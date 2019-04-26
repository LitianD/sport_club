package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.JsonBean.ResData;
import com.bjtu.j2ee.sport_club.JsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.bean.*;


public interface CourseServiceTest {

    ResponseJson getCourseList(Integer page, Integer size);
    ResponseJson getCourse(Integer id);
    ResponseJson getMyCourse(ReqMyCourse reqMyCourse);

}
