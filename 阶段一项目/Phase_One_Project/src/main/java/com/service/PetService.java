package com.service;

import com.pojo.Pet;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 18:22 2021/8/19
 * @Param Phase_One_Project
 * @Title: 宠物业务逻辑层接口
 * @Package com.service
 **/
public interface PetService {
    void showPet();
    void showMyPet(int id);
    int play(int health,int love,int uid,int id);
    void showTradable();

}
