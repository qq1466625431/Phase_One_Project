package com.dao;

import com.pojo.Merchant;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 9:24 2021/8/20
 * @Param Phase_One_Project
 * @Title: 商家数据访问层
 * @Package com.dao
 **/
public interface MerchantDao {
    Merchant MLogin(String username);//商家登录
    int MUpdate(Merchant merchant);//修改信息
    List<Merchant> showMerchant();//查询所有商家
    Merchant showMyMerchant(int mid);//查看本店信息
    int Breed(Object... obj);//培养宠物
    String MNaem(int id);//获取店铺名称
    int Register(Merchant merchant);//开店的功能

}
