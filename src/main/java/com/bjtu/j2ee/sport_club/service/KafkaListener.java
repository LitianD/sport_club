package com.bjtu.j2ee.sport_club.service;


import com.bjtu.j2ee.sport_club.ReqJsonBean.ReqAddUserCourse;
import com.bjtu.j2ee.sport_club.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Slf4j
public class KafkaListener {

    CourseService courseService;

    @Autowired
    public void setCourseService(@RequestBody CourseService courseService)
    {
        this.courseService = courseService;
    }


    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload ReqAddUserCourse reqAddUserCourse) {
        log.info("Received greetings: {}", reqAddUserCourse);

        courseService.addUserCourse(reqAddUserCourse);
    }
}
