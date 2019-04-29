package com.bjtu.j2ee.sport_club.ResJsonBean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserData extends ResData  implements Serializable {
	private String username;
	private String name;
	private String mail;
	private String phonenumber;
	private String age;
	private String sex;
}
