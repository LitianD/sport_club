package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.bean.*;
import com.bjtu.j2ee.sport_club.domain.Course;
import com.bjtu.j2ee.sport_club.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public void SetCourseRespository(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public ResCourseList getCourseList(){
        ResCourseList resCourseList = new ResCourseList();
        resCourseList.setCode("0");

        Iterable<Course> courses = courseRepository.findAll();
        return resCourseList;
    }

    @Override
    public ResCourse getCourse(ReqCourse reqCourse){
        ResCourse resCourse = new ResCourse();
        return resCourse;
    }

    @Override
    public ResCoach getCoach(ReqCoach reqCoach){
        ResCoach resCoach = new ResCoach();
        return  resCoach;
    }

    @Override
    public ResMyCourse getMyCourse(ReqMyCourse reqMyCourse){
        ResMyCourse resMyCourse = new ResMyCourse();
        return  resMyCourse;
    }
}
