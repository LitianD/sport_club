package com.bjtu.j2ee.sport_club.service;


import com.bjtu.j2ee.sport_club.bean.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public ResSignup createUser(ReqSignup reqSignup){
		ResSignup resSignup = new ResSignup();

		return resSignup;
	}

	@Override
	public ResSignin searchUser(ReqSignin reqSignin){
		ResSignin resSignin = new ResSignin();

		return resSignin;
	}

	@Override
	public ResUpdate updateUser(ReqUpdate reqUpdate){
		ResUpdate respdate= new ResUpdate();

		return respdate;
	}
}
