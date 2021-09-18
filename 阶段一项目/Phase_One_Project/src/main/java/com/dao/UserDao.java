package com.dao;

import com.pojo.User;

import java.util.List;

/*
 * @Author 止水
 * @Description //
 * @Date 19:14 2021/8/18
 * @Param Phase_One_Project
 * @Title:
 * @Package com.dao
 **/
public interface UserDao {
    User Login(String username);//登录
    int Register(User user);//注册
    int Update(User user);//修改用户
    List<User> showUsers();//查询所有用户
    User showMyUser(int id);//查询个人信息
    String UName(int id);//获取用户名

}
