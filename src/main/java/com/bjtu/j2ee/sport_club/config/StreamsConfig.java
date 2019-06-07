package com.bjtu.j2ee.sport_club.config;


import com.bjtu.j2ee.sport_club.stream.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
