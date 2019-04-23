package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.bean.*;
import com.bjtu.j2ee.sport_club.domain.User;

public interface UserService {

	ResSignup createUser(ReqSignup reqSignup);
	ResSignin searchUser(ReqSignin reqSignin);
	ResUpdate updateUser(ReqUpdate reqUpdate);
}
