package com.bjtu.j2ee.sport_club.config;



import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@EnableResourceServer
//@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{


	@Override
		public void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**").permitAll();
//			 .anyRequest().authenticated();
			http.requestMatchers().antMatchers("/api/v1/course/list/{page}/{size}")
			.and().authorizeRequests()
			.antMatchers("/api/v1/course/list/{page}/{size}").access("hasRole('USER')");
		}   

}

