package com.bjtu.j2ee.sport_club.ResJsonBean;
import java.io.Serializable;
import lombok.Data;

@Data
public abstract class ResData implements Serializable {
	private String error_msg;

}
