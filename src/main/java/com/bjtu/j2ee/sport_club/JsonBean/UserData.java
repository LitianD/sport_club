package com.bjtu.j2ee.sport_club.JsonBean;

import lombok.Data;

@Data
public class UserData extends ResData {
	private String username;
	private String name;
	private String mail;
	private String phonenumber;
	private String age;
	private String sex;
}
