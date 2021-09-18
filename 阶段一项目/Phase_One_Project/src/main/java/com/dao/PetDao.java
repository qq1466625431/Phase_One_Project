package com.dao;

import com.pojo.Pet;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 11:47 2021/8/19
 * @Param Phase_One_Project
 * @Title: 宠物数据访问接口
 * @Package com.dao.impl
 **/
public interface PetDao {
    List<Pet> showPet();//查看所有宠物
    List<Pet> showTradable();//查看可交易的宠物
    int buyPet(int pid,int uid,int mid,double price);//购买宠物
    int sellPet(int pid,int uid,int mid,double price);//卖出宠物
    List<Pet> showMyPet(int id);//查看个人宠物
    int play(Object... obj);//和宠物互动
    int setName(String name,int uid);//修改宠物昵称
    List<Pet> showMyMPet(int mid);//查询本店的宠物信息
    int UpdatePet(Object... obj);//修改宠物状态(五个参数 name=? exchange=? pet_price=? merchant_id=? pid=?)
    String PetName(int id);//查询宠物昵称
}
