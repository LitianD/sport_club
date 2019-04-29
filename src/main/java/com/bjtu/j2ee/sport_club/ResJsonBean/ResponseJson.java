package com.bjtu.j2ee.sport_club.ResJsonBean;

import lombok.Data;

@Data
public class ResponseJson {
	private Integer code;
	//private String error_msg;
	private ResData data;
}
