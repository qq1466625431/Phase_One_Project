package com.dao.impl;

import com.dao.MerchantDao;
import com.dao.Recharge;
import com.pojo.Merchant;
import com.pojo.Order;
import com.pojo.Pet;
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
 * @Date 9:37 2021/8/20
 * @Param Phase_One_Project
 * @Title: 商家数据处理实现类
 * @Package com.dao.impl
 **/
public class MerchantDaoImpl implements MerchantDao,Recharge{
    private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    private String sql;

    @Override
    public Merchant MLogin(@NotNull String username) {//商家登录

        sql = "select * from merchant where  musername= ?;";
        Merchant merchant=null;
        try {
            merchant = qr.query(sql, new BeanHandler<>(Merchant.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return merchant;
    }

    @Override
    public int MUpdate(@NotNull Merchant merchant) {//更新商家信息
        int update=0;
        sql = "update merchant set musername = ?,mpassword = ?,moldusername=? where musername =? ;";
        String[] str = {merchant.getMusername(),merchant.getMpassword(),merchant.getMoldusername(),merchant.getMoldusername()};
        try {
            update = qr.update(sql,str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public List<Merchant> showMerchant() {//查看所有商家信息
        sql = "select * from merchant;";
        List<Merchant> userinfo = null;
        try {
            userinfo = qr.query(sql, new BeanListHandler<Merchant>(Merchant.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userinfo;
    }

    @Override
    public Merchant showMyMerchant(@NotNull int mid) {//查看我的商家信息
        sql = "select * from merchant where mid =?";
       Merchant merchant=null;
        try {
            merchant = qr.query(sql, new BeanHandler<Merchant>(Merchant.class), mid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return merchant;
    }

    @Override
    public int Breed(@NotNull Object... obj) {//培育宠物
        sql = "insert into pet(name,pet_type,health,love,merchant_id,pet_price) values(?,?,?,?,?,?)";
        int breed = 0;
        try {
             breed = qr.update(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return breed;
    }





    @Override
    public String MNaem(@NotNull int id) {//获取商家名
        Merchant merchant = showMyMerchant(id);
        String name = merchant.getMusername();
        return name;
    }

    @Override
    public int Register(@NotNull Merchant merchant) {//商家注册
        sql = "insert into merchant(musername,mpassword) values(?,?)";
        int update = 0;
        try {
            update= qr.update(sql, merchant.getMusername(), merchant.getMpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public int Recharges( int id, double money) {
        sql = "update merchant set balance =+ ? where mid = ?";
        int flag =0;
        try {
            flag = qr.update( sql, money, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
