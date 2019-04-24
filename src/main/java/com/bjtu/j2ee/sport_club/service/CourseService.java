package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.bean.*;


public interface CourseService {
    ResCourseList getCourseList(Integer page, Integer size);
    ResCourse getCourse(ReqCourse reqCourse);
    ResCoach getCoach(ReqCoach reqCoach);
    ResMyCourse getMyCourse(ReqMyCourse reqMyCourse);
}
