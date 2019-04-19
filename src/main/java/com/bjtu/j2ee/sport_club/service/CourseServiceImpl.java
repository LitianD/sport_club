package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.bean.*;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    public ResCourseList getCourseList(){
        ResCourseList resCourseList = new ResCourseList();
        return resCourseList;
    }
    public ResCourse getCourse(ReqCourse reqCourse){
        ResCourse resCourse = new ResCourse();
        return resCourse;
    }
    public ResCoach getCoach(ReqCoach reqCoach){
        ResCoach resCoach = new ResCoach();
        return  resCoach;
    }
    public ResMyCourse getMyCourse(ReqMyCourse reqMyCourse){
        ResMyCourse resMyCourse = new ResMyCourse();
        return  resMyCourse;
    }
}
