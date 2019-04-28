package com.bjtu.j2ee.sport_club.ResJsonBean;

import lombok.Data;

@Data
public class CourseContent extends ResData {
	private Integer id;
	private String name;
	private CoachJson coach;
	private GymJson gym;
	private Double cost;
	private String content;
	private String time;

	@Data
	public static class CoachJson{
		private Integer id;
		private String name;
		private Integer sex;
		private Integer age;
		private String phoneNumber;
		private String mail;
		private String content;
	}

	@Data
	public static class GymJson{
		private Integer id;
		private String name;
		private String address;
	}
}
