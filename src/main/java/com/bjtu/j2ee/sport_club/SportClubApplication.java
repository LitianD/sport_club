package com.bjtu.j2ee.sport_club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SportClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportClubApplication.class, args);
	}
}
