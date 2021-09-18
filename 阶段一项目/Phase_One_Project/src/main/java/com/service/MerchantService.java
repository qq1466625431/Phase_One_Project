package com.service;

import com.pojo.Merchant;
import com.pojo.Order;
import com.pojo.Pet;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 10:56 2021/8/20
 * @Param Phase_One_Project
 * @Title: 宠物商店业务逻辑层
 * @Package com.service
 **/
public interface MerchantService {
    int  MLogin(String username, String password);//商家登录
    int  MUpdate(String username,String password,String oldusername);//修改信息
    void  showMerchant();//查询所有商家
    void showMyMerchant(int mid);//查看本店信息
    int Breed(Object... obj);//培养宠物
    void showMyMPet(int mid);//查询本店的宠物信息
    int UpdatePet(Object... obj);//商家更新宠物信息
    int Mrecharg(int id,double money);//商家充值
    public int Register(String name,String password);//商家注册
    public int getMid(int id);


}
