package com.bjtu.j2ee.sport_club.JsonBean;

import lombok.Data;

import java.util.List;

@Data
public class CourseData extends ResData{
	List<CourseListItem> courseList;
	Long total;

	@Data
	public  static class CourseListItem {
		private String id;
		private String name;
		private String coachName;
		private String coachID;
		private String gymName;
		private String gymID;
		private String address;
		private String cost;
		private String Content;
		private String time;
	}

}
