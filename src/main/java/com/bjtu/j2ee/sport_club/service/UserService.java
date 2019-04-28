package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;

public interface UserService {
	ResponseJson createUser(ReqSignup reqSignup);
	ResponseJson searchUser(ReqSignin reqSignin);
	ResponseJson updateUser(ReqUpdate reqUpdate);
}
