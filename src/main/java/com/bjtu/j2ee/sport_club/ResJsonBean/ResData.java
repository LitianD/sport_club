package com.bjtu.j2ee.sport_club.ResJsonBean;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class ResData implements Serializable {
	private String error_msg;

}
