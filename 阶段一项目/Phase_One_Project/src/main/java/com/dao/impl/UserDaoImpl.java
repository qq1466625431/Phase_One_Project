package com.dao.impl;

import com.dao.Recharge;
import com.dao.UserDao;
import com.pojo.User;
import com.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 20:09 2021/8/18
 * @Param Phase_One_Project
 * @Title: 用户数据访问层实现类
 * @Package com.dao.impl
 **/
public class UserDaoImpl implements UserDao,Recharge {
    private final QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    private String sql;

    @Override
    public User Login(@NotNull String username) {//登录
        sql = "select * from user where  username= ?;";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int Register(@NotNull User user) {//注册
        sql = "insert into user(username,password) values(?,?)";
        String[] str = {user.getUsername(), user.getPassword()};
        int insert = 0;
        try {
            insert = qr.update(sql, str);
        } catch (SQLException e) {

        }
        return insert;
    }

    @Override
    public int Update(@NotNull User user) {//更新
        int update = 0;
        sql = "update user set username = ?,password = ?,oldusername=? where username =? ;";
        String[] str = {user.getUsername(), user.getPassword(), user.getOldusername(), user.getOldusername()};
        try {
            update = qr.update(sql, str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public List<User> showUsers() {//查询所有用户
        sql = "select * from user;";
        List<User> userinfo = null;
        try {
            userinfo = qr.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userinfo;
    }

    @Override
    public User showMyUser(@NotNull int id) {//查询个人信息
        sql = "select * from user where uid =?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String UName(@NotNull int id) {//查询个人名称

        String name = showMyUser(id).getUsername();

        return name;
    }


    @Override
    public int Recharges(int id, double money) {
        sql = "update user set money =+ ? where uid = ?";
        int flag =0;
        try {
            flag = qr.update( sql, money, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

