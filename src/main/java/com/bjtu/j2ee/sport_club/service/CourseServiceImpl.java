package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.bean.*;
import com.bjtu.j2ee.sport_club.domain.Coach;
import com.bjtu.j2ee.sport_club.domain.Course;
import com.bjtu.j2ee.sport_club.domain.User;
import com.bjtu.j2ee.sport_club.repository.CoachRepository;
import com.bjtu.j2ee.sport_club.repository.CourseRepository;
import com.bjtu.j2ee.sport_club.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private CoachRepository coachRepository;
    private UserRepository userRepository;
    @Autowired
    public void SetCourseRespository(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    @Autowired
    public void SetCoachResposity(CoachRepository coachRepository){this.coachRepository = coachRepository;}
    @Autowired
    public void SetUserResposity(UserRepository userRepository){this.userRepository = userRepository;}
    @Override
    public ResCourseList getCourseList(){
        ResCourseList resCourseList = new ResCourseList();
        resCourseList.setCode("0");
        Iterable<Course> courses = courseRepository.findAll();
        for(Course course : courses){
            ResCourseList.DataBean datas = new ResCourseList.DataBean();
            datas.setId(course.getId().toString());
            datas.setName(course.getName());
            datas.setCoachName(course.getCoach().getName());
            datas.setCoachID(course.getCoach().getId().toString());
            datas.setGymName(course.getGym().getName());
            datas.setGymID(course.getGym().getId().toString());
            datas.setAddress(course.getGym().getAddress());
            datas.setCost(course.getCost().toString());
            datas.set_$Content206(course.getContent());
            datas.setTime(course.getTime());
            resCourseList.getData().add(datas);
        }
        return resCourseList;
    }

    @Override
    public ResCourse getCourse(ReqCourse reqCourse){
        ResCourse resCourse = new ResCourse();
        resCourse.setCode("0");
        Course course = courseRepository.findById(Integer.valueOf(reqCourse.getId())).orElse(null);
        ResCourse.DataBean datas = new ResCourse.DataBean();
        datas.setId(course.getId().toString());
        datas.setName(course.getName());
        datas.getCoach().setId(course.getCoach().getId().toString());
        datas.getCoach().setName(course.getCoach().getName());
        if(course.getCoach().getSex()==0){
            datas.getCoach().setSex("女");
        }
        else
            datas.getCoach().setSex("男");
        datas.getCoach().setAge(course.getCoach().getAge().toString());
        datas.getCoach().setPhoneNumber(course.getCoach().getPhoneNumber());
        datas.getCoach().setMail(course.getCoach().getMail());
        datas.getCoach().setContent(course.getCoach().getContent());
        datas.getGym().setId(course.getGym().getId().toString());
        datas.getGym().setName(course.getGym().getName());
        datas.getGym().setAddress(course.getGym().getAddress());
        datas.setCost(course.getCost().toString());
        datas.setTime(course.getTime());
        datas.set_$Content230(course.getContent());
        return resCourse;
    }

    @Override
    public ResCoach getCoach(ReqCoach reqCoach){
        ResCoach resCoach = new ResCoach();
        Coach coach = coachRepository.findById(Integer.valueOf(reqCoach.getId())).orElse(null);
        resCoach.setCode("0");

        ResCoach.DataBean dataBean = new ResCoach.DataBean();
        dataBean.setId(coach.getId().toString());
        dataBean.setName(coach.getName());
        dataBean.setAge(coach.getAge().toString());
        if(coach.getSex()==0){
            dataBean.setSex("女");
        }
        else
            dataBean.setSex("男");
        dataBean.setPhoneNumber(coach.getPhoneNumber());
        dataBean.setMail(coach.getMail());
        dataBean.setContent(coach.getContent());

        for(Course course : coach.getCourseList()){
            ResCoach.DataBean.CoursesBean datas= new ResCoach.DataBean.CoursesBean();
            datas.setId(course.getId().toString());
            datas.setName(course.getName());
            datas.setCoachName(course.getCoach().getName());
            datas.setCoachID(course.getCoach().getId().toString());
            datas.setGymName(course.getGym().getName());
            datas.setGymID(course.getGym().getId().toString());
            datas.setAddress(course.getGym().getAddress());
            datas.setCost(course.getCost().toString());
            datas.set_$Content206(course.getContent());
            datas.setTime(course.getTime());
            dataBean.getCourses().add(datas);
        }
        return  resCoach;
    }

    @Override
    public ResMyCourse getMyCourse(ReqMyCourse reqMyCourse){
        ResMyCourse resMyCourse = new ResMyCourse();
        User user = userRepository.findById(Integer.valueOf(reqMyCourse.getId())).orElse(null);
        for(Course course : user.getCourseList()){
            ResMyCourse.DataBean dataBean = new ResMyCourse.DataBean();
            dataBean.setId(course.getId().toString());
            dataBean.setName(course.getName());
            dataBean.setCoachName(course.getCoach().getName());
            dataBean.setCoachID(course.getCoach().getId().toString());
            dataBean.setGymName(course.getGym().getName());
            dataBean.setGymID(course.getGym().getId().toString());
            dataBean.setAddress(course.getGym().getAddress());
            dataBean.setCost(course.getCost().toString());
            dataBean.set_$Content100(course.getContent());
            dataBean.setTime(course.getTime());
            resMyCourse.getData().add(dataBean);
        }
        return  resMyCourse;
    }
}
