package com.Controller;

import com.service.Impl.MerchantServiceImpl;
import com.service.Impl.PetServiceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.PetService;
import com.service.UserService;

/*
 * @Author 止水
 * @Description //todo
 * @Date 16:05 2021/8/20
 * @Param Phase_One_Project
 * @Title: 公开方法(不需要传参,不需要登录便可以操作的方法)
 * @Package com.Controller
 **/
public class PublicMethods {
    private MerchantServiceImpl merchantService = new MerchantServiceImpl();
    private final UserService user = new UserServiceImpl();
    private final PetService pet = new PetServiceImpl();
    public void showMerchant(){

        System.out.println("--------------查看所有商铺信息----------");
        System.out.println("序号\t用户id\t用户名");
        merchantService.showMerchant();
        System.out.println("------------------end-----------------");
    }
    public void showPet() {
        System.out.println("--------------查看所有宠物------------------");
        System.out.println("序号\t宠物编号\t宠物昵称\t宠物类型\t\t宠物出生日期");
        pet.showPet();
        System.out.println("------------------end-----------------");
    }

    public void showUsers() {
        System.out.println("------------------所有用户信息---------------");
        System.out.println("序号\t用户编号\t" + "用户名");
        user.showUsers();
        System.out.println("------------------end-----------------");
    }

}
