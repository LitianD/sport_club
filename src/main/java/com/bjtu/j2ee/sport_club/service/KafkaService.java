package com.bjtu.j2ee.sport_club.service;


import com.bjtu.j2ee.sport_club.ReqJsonBean.ReqAddUserCourse;
import com.bjtu.j2ee.sport_club.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class KafkaService {
    private final GreetingsStreams greetingsStreams;

	@Autowired
    public KafkaService(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }

    public void sendGreeting(ReqAddUserCourse reqAddUserCourse) {
        log.info("Sending greetings {}",reqAddUserCourse);

        MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(reqAddUserCourse)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
