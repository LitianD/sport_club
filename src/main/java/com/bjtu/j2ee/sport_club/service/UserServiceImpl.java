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

			ResSignup.DataBean data = new ResSignup.DataBean();
			data.setName(user.getName());
			data.setAge(String.valueOf(user.getAge()));
			data.setMail(user.getMail());
			data.setPhonenumber(user.getPhoneNumber());
			data.setSex(String.valueOf(user.getSex()));

			resSignup.setData(data);
		}

		return resSignup;
	}

	@Override
	public ResSignin searchUser(ReqSignin reqSignin){
		ResSignin res = new ResSignin();
		List<User> userList = userRepository.findByUsernameAndPassword(reqSignin.getUsername(),reqSignin.getPassword());
		if (userList.size()==1)
		{
			User user = userList.get(0);
			res.setCode("0");
			ResSignin.DataBean data = new ResSignin.DataBean();
			data.setName(user.getName());
			data.setAge(String.valueOf(user.getAge()));
			data.setMail(user.getMail());
			data.setPhonenumber(user.getPhoneNumber());
			data.setSex(String.valueOf(user.getSex()));

			res.setData(data);
		}
		else
		{
			res.setCode("-1");
			res.setError_msg("密码错误或用户名不存在");
		}

		return res;
	}

	@Override
	public ResUpdate updateUser(ReqUpdate reqUpdate){
		ResUpdate res= new ResUpdate();
		List<User> userList = userRepository.findByUsernameAndPassword(reqUpdate.getOldusername(),reqUpdate.getOldpassword());
		if(userList.size()==1)
		{
			User user = userList.get(0);

			if(reqUpdate.getPassword().equals(reqUpdate.getRepassword()))
			{
				List<User> newuserList = userRepository.findByUsernameAndPassword(reqUpdate.getUsername(),reqUpdate.getOldpassword());
				if(newuserList.size()==1)
				{
					res.setCode("-1");
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

					res.setCode("0");

					ResUpdate.DataBean data = new ResUpdate.DataBean();
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
				res.setCode("-1");
				res.setError_msg("两次密码不一致");
			}
		}
		else
		{
			res.setCode("-1");
			res.setError_msg("旧密码错误");
		}
		return res;
	}
}
