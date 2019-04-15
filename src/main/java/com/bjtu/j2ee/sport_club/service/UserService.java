package com.bjtu.j2ee.sport_club.service;

import com.bjtu.j2ee.sport_club.domain.User;

public interface UserService {

    Iterable<User> getAllUsers();

    //没有返回null
    User login(String username, String password);
    //是否存在这个用户
    boolean haveUser(String username, String password);
    //注册
    boolean register(User user);
    //找回密码，向邮箱发密码，以后再写
    boolean sendEmail(String username);
    //获得user信息
    User getUser(Integer userId);
    //修改信息
    boolean modifyUser(User user);
    //添加课程
    boolean addCourse(Integer courseId);
    //删除课程
    boolean delCourse(Integer courseId);


}
