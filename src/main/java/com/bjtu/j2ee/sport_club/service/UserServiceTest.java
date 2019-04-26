package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.JsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.bean.*;

public interface UserServiceTest {
	ResponseJson createUser(ReqSignup reqSignup);
	ResponseJson searchUser(ReqSignin reqSignin);
	ResponseJson updateUser(ReqUpdate reqUpdate);
}
