package com.bjtu.j2ee.sport_club.service;


import com.bjtu.j2ee.sport_club.bean.*;
import com.bjtu.j2ee.sport_club.domain.User;
import com.bjtu.j2ee.sport_club.repository.ContactRepository;
import com.bjtu.j2ee.sport_club.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public ResSignup createUser(ReqSignup reqSignup){
		ResSignup resSignup = new ResSignup();
		List<User> userList = userRepository.findByUsername(reqSignup.getName());
		if(userList.size()==1) {
			resSignup.setCode("-1");
			resSignup.setError_msg("用户已经存在");
		}
		else
		{
			resSignup.setCode("0");
			User user = new User();
			user.setUsername(reqSignup.getUsername());
			user.setName(reqSignup.getName());
			user.setPassword(reqSignup.getPassword());
			user.setMail(reqSignup.getMail());
			user.setAge(Integer.valueOf(reqSignup.getAge()));
			userRepository.save(user);
		}

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
