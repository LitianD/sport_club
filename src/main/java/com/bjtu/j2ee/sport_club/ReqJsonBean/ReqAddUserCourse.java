package com.bjtu.j2ee.sport_club.ReqJsonBean;


import lombok.Data;

import java.io.Serializable;

@Data
public class ReqAddUserCourse implements Serializable {
	String username;
	Integer id;
}
