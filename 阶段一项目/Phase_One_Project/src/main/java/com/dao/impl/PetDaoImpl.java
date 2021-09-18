package com.dao.impl;


import com.dao.PetDao;
import com.pojo.Pet;
import com.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Or;
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
 * @Date 17:27 2021/8/19
 * @Param Phase_One_Project
 * @Title: 宠物数据访问实现类
 * @Package com.dao.impl
 **/
public class PetDaoImpl implements PetDao {
    private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    private String sql ;
    private List<Pet> pets=null;
    private OrderDaoImpl orderDao = new OrderDaoImpl();

    @Override
    public List<Pet> showPet() {
        sql = "select * from pet;";
//        List<Pet> pets=null;
        try {
            pets = qr.query(sql, new BeanListHandler<Pet>(Pet.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public List<Pet> showTradable() {
        sql="select * from  pet where Exchange=1 ";
        try {
            pets = qr.query(sql,new BeanListHandler<Pet>(Pet.class));
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public int buyPet(int pid,int uid,int mid,double price) {
        int flag = 0;
        String sql_ureduce = "update user set money=money-? where uid =? ";//修改用户金额
        String sql_madd = "update merchant set balance=balance+? where mid = ?";//修改商家表
        String sql_updatePet = "update pet set user_id=?,exchange = 2 where pid = ?";//修改宠物表
        try {
            int update = qr.update(sql_ureduce, price, uid);//修改用户金额
            int tally = orderDao.tally(1,pid,mid,uid,price);//添加订单
            int madd = qr.update(sql_madd, price, mid);//修改商家表
            int upPet = qr.update(sql_updatePet, uid, pid);//修改宠物表
            if (update>0&&madd>0&&tally>0&&upPet>0){
                flag=1;
            }
        } catch (SQLException e) {
            System.out.println("你的余额不足!");
        }


        return flag;
    }

    @Override
    public int sellPet(int pid,int uid,int mid,double price) {
        int flag = 0;
        String sql_ureduce = "update user set money=money+? where uid =? ";//修改用户金额
        String sql_madd = "update merchant set balance=balance-? where mid = ?";//修改商家表
        String sql_updatePet = "update pet set user_id=null,merchant_id = ?,exchange = 1 where pid = ?";//修改宠物表
        try {
            int update = qr.update(sql_ureduce, price, uid);//修改用户金额
            int tally = orderDao.tally(2,pid,uid,mid,price);//添加订单
            int madd = qr.update(sql_madd, price, mid);//修改商家表
            int upPet = qr.update(sql_updatePet, mid, pid);//修改宠物表
            if (update>0&&madd>0&&tally>0&&upPet>0){
                flag=1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return flag;
    }


    @Override
    public List<Pet> showMyPet(@NotNull int id) {//查询某个人的宠物
        sql="select * from  pet p,user u where  p.User_id=u.Uid and p.User_id=?";
        try {
            pets = qr.query(sql,new BeanListHandler<Pet>(Pet.class),id);
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public int play(@NotNull Object... obj) {//和宠物互动
        sql = "update pet set health=health+?,love = love+? where user_id=? and Pid = ?";
        int update = 0;
        try {
            update = qr.update(sql, obj);
        } catch (SQLException e) {


        }
        return update;
    }
    @Override
    public List<Pet> showMyMPet(@NotNull int mid) {
        sql = "select * from pet where merchant_id = ?";
        List<Pet> pets=null;
        try {
            pets= qr.query(sql, new BeanListHandler<Pet>(Pet.class), mid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public int UpdatePet(@NotNull Object... obj) {
        sql ="update pet set name=?,exchange=?,pet_price=? where merchant_id=? and pid=?";
        int update=0;
        try {
            update = qr.update(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public String PetName(@NotNull int id) {
        sql = "select * from pet where Pid =?";
        String name =null;
        try {
            Pet query = qr.query(sql, new BeanHandler<Pet>(Pet.class), id);
            if (query!=null){
                name = query.getName();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public int setName(@NotNull String name,int uid) {
        sql = "update pet set name=? where Pid=?";
        int setName=0;
        try {
            setName = qr.update(sql, name, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setName;
    }

}
