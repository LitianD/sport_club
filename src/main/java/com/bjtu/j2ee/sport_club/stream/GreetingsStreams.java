package com.bjtu.j2ee.sport_club.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;


@Component(value = "GreetingsStreams")
public interface GreetingsStreams {
    String INPUT = "greetings-in";
    String OUTPUT = "greetings-out";

    @Input(INPUT)
	SubscribableChannel inboundGreetings();

    @Output(OUTPUT)
	MessageChannel outboundGreetings();
}
