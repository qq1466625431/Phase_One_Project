package com.service;

import com.pojo.User;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 20:02 2021/8/18
 * @Param Phase_One_Project
 * @Title: 用户数据处理接口
 * @Package com.service
 **/
public interface UserService {
    int Login(String username,String password);
    int Register(String username,String password);
    int Update(String username,String password,String oldusername);
    void showUsers();
    void showMyUser(int id);
    int Urecharg(int id,double money);
    int Buy(int uid);//买宠物的方法
    int Sell(int uid);//卖宠物的方法

}
