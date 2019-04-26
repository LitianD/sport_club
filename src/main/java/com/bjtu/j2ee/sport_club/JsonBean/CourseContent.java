package com.bjtu.j2ee.sport_club.JsonBean;

import lombok.Data;

@Data
public class CourseContent extends ResData {
	private String id;
	private String name;
	private CoachJson coach;
	private GymJson gym;
	private String cost;
	private String _Content;
	private String time;

	@Data
	public class CoachJson{
		private String id;
		private String name;
		private String sex;
		private String age;
		private String phoneNumber;
		private String mail;
		private String content;
	}

	@Data
	public class GymJson{
		private String id;
		private String name;
		private String address;
	}
}
