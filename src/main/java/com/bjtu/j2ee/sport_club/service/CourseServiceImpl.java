package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.ResJsonBean.CourseContent;
import com.bjtu.j2ee.sport_club.ResJsonBean.CourseData;
import com.bjtu.j2ee.sport_club.ResJsonBean.ResData;
import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;
import com.bjtu.j2ee.sport_club.domain.Course;
import com.bjtu.j2ee.sport_club.domain.User;
import com.bjtu.j2ee.sport_club.repository.CourseRepository;
import com.bjtu.j2ee.sport_club.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    private UserRepository userRepository;

    @Autowired
    public void SetCourseRespository(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void SetUserResposity(UserRepository userRepository){this.userRepository = userRepository;}
    
    @Override
    public ResponseJson getCourseList(Integer page, Integer size) {
        ResponseJson resCourseList = new ResponseJson();
        CourseData courseData = new CourseData();
        resCourseList.setCode(0);
        PageRequest pageSet = PageRequest.of(page, size);
        Iterable<Course> courses = courseRepository.findAll(pageSet);
        Long coursesNum = courseRepository.count();
        List<CourseData.CourseListItem> list = new ArrayList<>();


        if(courses==null)
        {
            resCourseList.setCode(1);
            //resCourseList.setError_msg("此页为空");
            courseData.setError_msg("此页为空");
            resCourseList.setData(courseData);
            return resCourseList;
        }

        for(Course course : courses){
            CourseData.CourseListItem data = new CourseData.CourseListItem();
            data.setId(course.getId().toString());
            data.setName(course.getName());
            data.setCoachName(course.getCoach().getName());
            data.setCoachID(course.getCoach().getId().toString());
            data.setGymName(course.getGym().getName());
            data.setGymID(course.getGym().getId().toString());
            data.setAddress(course.getGym().getAddress());
            data.setCost(course.getCost().toString());
            data.setContent(course.getContent());
            data.setTime(course.getTime());
            list.add(data);
        }

        if (coursesNum !=null)
        {
            courseData.setError_msg("此页为空");
            courseData.setTotal(coursesNum);
        }

        courseData.setCourseList(list);
        resCourseList.setData(courseData);
        return resCourseList;
    }

    @Override
    public ResponseJson getCourse(Integer id){
        ResponseJson response = new ResponseJson();
        response.setCode(0);
        Course course = courseRepository.findById(id).orElse(null);
        CourseContent courseContent = new CourseContent();

        if(course==null)
        {
            response.setCode(1);
            //response.setError_msg("没有此课程");
            courseContent.setError_msg("没有此课程");
            response.setData(courseContent);
            return response;
        }


        CourseContent.CoachJson coachJson = new CourseContent.CoachJson();
        CourseContent.GymJson gymJson = new CourseContent.GymJson();

        courseContent.setId(course.getId());
        courseContent.setCost(course.getCost());
        courseContent.setName(course.getName());
        courseContent.setContent(course.getContent());
        courseContent.setTime(course.getTime());

        coachJson.setAge(course.getCoach().getAge());
        coachJson.setContent(course.getCoach().getContent());
        coachJson.setId(course.getCoach().getId());
        coachJson.setMail(course.getCoach().getMail());
        coachJson.setName(course.getCoach().getName());
        coachJson.setPhoneNumber(course.getCoach().getPhoneNumber());
        coachJson.setSex(course.getCoach().getSex());

        gymJson.setAddress(course.getGym().getAddress());
        gymJson.setId(course.getGym().getId());
        gymJson.setName(course.getGym().getName());

        courseContent.setCoach(coachJson);
        courseContent.setGym(gymJson);

        response.setData(courseContent);
        return response;
    }


    @Override
    public ResponseJson getMyCourse(ReqMyCourse reqMyCourse){
        ResponseJson resMyCourse = new ResponseJson();
        Iterable<User> iterableUser  = userRepository.findByUsername(reqMyCourse.getUsername());
        if(iterableUser==null||((List<User>) iterableUser).size()==0)
        {
            ResData data = new CourseData();
            resMyCourse.setCode(1);
            //resMyCourse.setError_msg("用户不存在");
            data.setError_msg("用户不存在");
            resMyCourse.setData(data);
            return  resMyCourse;
        }
        User user = ((List<User>) iterableUser).get(0);
        List<CourseData.CourseListItem> myCourses = new ArrayList<>();
        resMyCourse.setCode(0);

        for(Course course : user.getCourseList()){
            CourseData.CourseListItem dataBean = new CourseData.CourseListItem();
            dataBean.setId(course.getId().toString());
            dataBean.setName(course.getName());
            dataBean.setCoachName(course.getCoach().getName());
            dataBean.setCoachID(course.getCoach().getId().toString());
            dataBean.setGymName(course.getGym().getName());
            dataBean.setGymID(course.getGym().getId().toString());
            dataBean.setAddress(course.getGym().getAddress());
            dataBean.setCost(course.getCost().toString());
            dataBean.setContent(course.getContent());
            dataBean.setTime(course.getTime());
            myCourses.add(dataBean);
        }

        CourseData courseData = new CourseData();
        courseData.setCourseList(myCourses);
        resMyCourse.setData(courseData);
        return  resMyCourse;
    }

    @Override
    public ResponseJson addUserCourse(ReqAddUserCourse reqAddUserCourse)
    {
        ResponseJson res = new ResponseJson();
        ResData data = new CourseData();
        Iterable<User> iterableUser  = userRepository.findByUsername(reqAddUserCourse.getUsername());
        if(iterableUser==null||((List<User>) iterableUser).size()==0)
        {
            res.setCode(1);
            //res.setError_msg("用户不存在");
            data.setError_msg("用户不存在");
            res.setData(data);
            return  res;
        }
        User user = ((List<User>) iterableUser).get(0);
        Course course = courseRepository.findById(reqAddUserCourse.getId()).orElse(null);

        if(course==null)
        {
            res.setCode(1);
            //res.setError_msg("没有此课程");
            data.setError_msg("没有此课程");
            res.setData(data);
            return res;
        }

        List<Course> courses= user.getCourseList();
        for(int i=0;i<courses.size();i++)
        {
            Integer id = courses.get(i).getId();
            if(id==reqAddUserCourse.getId())
            {
                res.setCode(1);
                //res.setError_msg("您已经添加此课程，不要重复添加");
                data.setError_msg("您已经添加此课程，不要重复添加");
                res.setData(data);
                return res;
            }

        }
        courses.add(course);
        user.setCourseList(courses);
        userRepository.save(user);
        res.setCode(0);
        //res.setError_msg("添加课程成功");

        return  res;
    }
}
