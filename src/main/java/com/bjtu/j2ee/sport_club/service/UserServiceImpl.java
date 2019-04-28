package com.bjtu.j2ee.sport_club.service;


import com.bjtu.j2ee.sport_club.ResJsonBean.ResponseJson;
import com.bjtu.j2ee.sport_club.ResJsonBean.UserData;
import com.bjtu.j2ee.sport_club.ReqJsonBean.*;
import com.bjtu.j2ee.sport_club.domain.User;
import com.bjtu.j2ee.sport_club.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public ResponseJson createUser(ReqSignup reqSignup){
		ResponseJson response = new ResponseJson();
		List<User> userList = new ArrayList<>();
		Iterable<User> iterableUser =userRepository.findByUsername(reqSignup.getUsername());
		for(User user:iterableUser)
		{
			userList.add(user);
		}
		if(userList.size()>=1) {
			response.setCode(-1);
			response.setError_msg("用户已经存在");
		}
		else
		{
			response.setCode(0);
			User user = new User();
			user.setUsername(reqSignup.getUsername());
			user.setName(reqSignup.getName());
			user.setPassword(reqSignup.getPassword());
			user.setMail(reqSignup.getMail());
			user.setAge(Integer.valueOf(reqSignup.getAge()));
			user.setSex(Integer.valueOf(reqSignup.getSex()));
			user.setPhoneNumber(reqSignup.getPhonenumber());
			userRepository.save(user);

			UserData data = new UserData();
			data.setUsername(user.getUsername());
			data.setName(user.getName());
			data.setAge(String.valueOf(user.getAge()));
			data.setMail(user.getMail());
			data.setPhonenumber(user.getPhoneNumber());
			data.setSex(String.valueOf(user.getSex()));

			response.setData(data);
		}

		return response;
	}

	@Override
	public ResponseJson searchUser(ReqSignin reqSignin){
		ResponseJson res = new ResponseJson();
		List<User> userList = new ArrayList<>();
		Iterable<User> iterableUser =userRepository.findByUsernameAndPassword(reqSignin.getUsername(),reqSignin.getPassword());
		for(User user:iterableUser)
		{
			userList.add(user);
		}
		if (userList.size()==1)
		{
			User user = userList.get(0);
			res.setCode(0);
			UserData data = new UserData();
			data.setName(user.getName());
			data.setAge(String.valueOf(user.getAge()));
			data.setMail(user.getMail());
			data.setPhonenumber(user.getPhoneNumber());
			data.setSex(String.valueOf(user.getSex()));
			data.setUsername(user.getUsername());

			res.setData(data);
		}
		else
		{
			res.setCode(-1);
			res.setError_msg("密码错误或用户名不存在");
		}

		return res;
	}

	@Override
	public ResponseJson updateUser(ReqUpdate reqUpdate){
		ResponseJson res= new ResponseJson();
		List<User> userList = userRepository.findByUsernameAndPassword(reqUpdate.getOldusername(),reqUpdate.getOldpassword());
		if(userList.size()==1)
		{
			User user = userList.get(0);

			if(reqUpdate.getPassword().equals(reqUpdate.getRepassword()))
			{
				List<User> newuserList = userRepository.findByUsernameAndPassword(reqUpdate.getUsername(),reqUpdate.getOldpassword());
				if(newuserList.size()==1)
				{
					res.setCode(-1);
					res.setError_msg("用户名已经存在");
				}
				else
				{
					user.setUsername(reqUpdate.getUsername());
					user.setName(reqUpdate.getName());
					user.setPassword(reqUpdate.getPassword());
					user.setMail(reqUpdate.getMail());
					user.setAge(Integer.valueOf(reqUpdate.getAge()));
					userRepository.delete(userList.get(0));
					userRepository.save(user);

					res.setCode(0);

					UserData data = new UserData();
					data.setName(user.getName());
					data.setUsername(user.getUsername());
					data.setAge(String.valueOf(user.getAge()));
					data.setMail(user.getMail());
					data.setPhonenumber(user.getPhoneNumber());
					data.setSex(String.valueOf(user.getSex()));

					res.setData(data);
				}
			}
			else
			{
				res.setCode(-1);
				res.setError_msg("两次密码不一致");
			}
		}
		else
		{
			res.setCode(-1);
			res.setError_msg("旧密码错误");
		}
		return res;
	}
}
