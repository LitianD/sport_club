package com.bjtu.j2ee.sport_club.ResJsonBean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CourseData extends ResData  implements Serializable {
	List<CourseListItem> courseList;
	Long total;

	@Data
	public  static class CourseListItem implements Serializable{
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
