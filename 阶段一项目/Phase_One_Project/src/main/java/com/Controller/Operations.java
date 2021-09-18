package com.Controller;

import com.Controller.Mothed.MerchantMethod;
import com.Controller.Mothed.UserMethod;

import java.util.Scanner;

/*
 * @Author 止水
 * @Description //todo
 * @Date 14:07 2021/8/19
 * @Param Phase_One_Project
 * @Title: 流程操作类
 * @Package com.test
 **/
public class Operations {
    private final Scanner sc = new Scanner(System.in);
    private final MerchantMethod mm = new MerchantMethod();
    private final UserMethod um = new UserMethod();

    /***
     * 用户的操作
     */
    public void User() {//用户未登录可操作的功能

        user:while (true) {
            System.out.println("1.用户登录\n" +
                    "2.用户注册\n" +
                    "0000.输入0000退回至主菜单");
            System.out.println("请选择:");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    boolean login = um.login();
                    if (login) {
                        uOptions();
                    }
                    break;
                case 2:
                    um.register();
                    break;
                case 0000:
                    break user;
                default:
                    System.out.println("没有该选项");
                    break;
            }

        }


    }

    public void uOptions() {//用户登录后可操作的功能
        uop:
        while (true) {
            System.out.println("1.查看我的个人信息\n" +
                    "2.查看我的宠物\n" +
                    "3.修改我的信息\n" +
                    "4.与宠物互动\n" +
                    "5.查看我的账单\n" +
                    "6.购买宠物\n" +
                    "7.出售宠物\n" +
                    "8.账户充值\n" +
                    "0000.输入0000退出登录");
            System.out.print("请选择:");
            int uop = 0;
            try {
                uop = sc.nextInt();
            } catch (Exception e) {
                System.out.println("你的输入有误,请重新操作");
            }
            switch (uop) {
                case 1:
                    um.showMyUser();
                    break;
                case 2:
                    um.showMyPet();
                    break;
                case 3:
                    um.update();
                    break;
                case 4:
                    um.play();
                    break;
                case 5:
                    um.showMyOrder();
                    break;
                case 6:
                    um.purchase();
                    break;
                case 7:
                    um.sell();
                    break;
                case 8:
                    um.Urecharge();
                    break;
                case 0000:
                    break uop;
                default:
                    System.out.println("没有该选项");
            }

        }

    }


    /**
     * 商家的操作
     */

    public void Merchant(){
        merchant:while (true) {
            System.out.println("1.商家登录\n" +
                    "2.我要开新店\n" +
                    "0000.输入0000退回至主菜单");
            System.out.println("请选择:");
            int op = 0;
            try {
                op = sc.nextInt();
            } catch (Exception e) {
                System.out.println("您的操作有误,请重新操作");
            }
            switch (op) {
                case 1:
                    boolean login = mm.Mlogin();
                    if (login) {
                        mOptions();
                    }
                    break;
                case 2:
                    mm.isBuiness();
                    break;
                case 0000:
                    break merchant;
                default:
                    System.out.println("没有该选项");
                    break;
            }

        }
    }
    public void mOptions() {//用户登录后可操作的功能
        mop:
        while (true) {
            System.out.println("1.查看我的个人信息\n" +
                    "2.查看我的宠物\n" +
                    "3.修改我的信息\n" +
                    "4.培育宠物\n" +
                    "5.查看我的账单\n" +
                    "6.账户充值\n" +
                    "0000.输入0000退出登录");
            System.out.print("请选择:");
            int uop = 0;
            try {
                uop = sc.nextInt();
            } catch (Exception e) {
                System.out.println("你的输入有误,请重新操作");
            }
            switch (uop) {
                case 1:
                    mm.showMyInfo();
                    break;
                case 2:
                    mm.showMPet();
                    break;
                case 3:
                    mm.Mupdate();
                    break;
                case 4:
                    mm.Breed();
                    break;
                case 5:
                    mm.Morder();
                    break;
                case 6:
                    mm.Mrecharge();
                    break;

                case 0000:
                    break mop;
                default:
                    System.out.println("没有该选项");
            }

        }

    }


}
