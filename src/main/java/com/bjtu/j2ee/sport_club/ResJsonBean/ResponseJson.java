package com.bjtu.j2ee.sport_club.ResJsonBean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseJson implements Serializable {
	private Integer code;
	private String error_msg;
	private ResData data;
}
