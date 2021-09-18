package com.Controller.Mothed;


import com.service.Impl.OrderServiceImpl;
import com.service.Impl.PetServiceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.OrderService;
import com.service.PetService;
import com.service.UserService;

import java.util.Scanner;

/*
 * @Author 止水
 * @Description //todo
 * @Date 14:06 2021/8/19
 * @Param Phase_One_Project
 * @Title: 方法调用类
 * @Package com.test
 **/
public class UserMethod {
    private final UserService user = new UserServiceImpl();
    private final PetService pet = new PetServiceImpl();
    private final Scanner sc = new Scanner(System.in);
    private String username = null;
    private String password = null;
    private int uid = 0;

    /**
     * 用户功能
     */
    //登录
    public boolean login() {
        System.out.println("---------------用户登录---------------");
        boolean isLogin = false;
        uid = 0;
        System.out.print("请输入用户名:");
        username = sc.next();
        System.out.print("请输入密码:");
        password = sc.next();
        uid = user.Login(username, password);
        if (uid != 0) {
            System.out.println("登录成功");
            isLogin=true;
            showMyUser();

        } else {
            System.out.println("登录失败,请重新输入");
            login();
        }
        System.out.println("------------------end-----------------");
        return isLogin;
    }

    //注册
    public void register() {
        System.out.println("----------------用户注册---------------");
        System.out.print("请输入用户名:");
        username = sc.next();
        System.out.print("请输入密码:");
        password = sc.next();
        System.out.print("请输入确认密码:");
        String password2 = sc.next();
        if (password2.equals(password)) {
            int register = user.Register(username, password);
            if (register > 0) {
                System.out.println("注册成功");
            } else {
                System.out.println("当前用户已存在");
            }
        } else {
            System.out.println("确认密码输入错误,请重新输入");
            register();
        }
        System.out.println("------------------end-----------------");
    }

    //改密码
    public void update() {
        System.out.println("------------------用户修改---------------");
        System.out.println(username);
        if (uid > 0) {
            System.out.print("请输入新的用户名");
            String username = sc.next();
            System.out.print("请输入新的密码");
            password = sc.next();
            int update = user.Update(username, password, this.username);
            if (update > 0) {
                System.out.println("修改成功");
                this.username = username;
            } else {
                System.out.println("当前用户名已存在");
            }
        } else {
            System.out.println("请先登录");
            login();
        }
        System.out.println("------------------end-----------------");

    }





    public void showMyPet() {
        System.out.println("--------------------您的宠物信息------------------");
        if (uid!=0) {
            System.out.println("序号\t宠物编号\t宠物昵称\t宠物类型\t\t宠物出生日期\t\t健康值\t与宠物的亲密度");
                pet.showMyPet(uid);
        }else{
            System.out.println("请先登录");
            login();
        }
        System.out.println("------------------end-----------------");

    }
    public void play(){
        System.out.println("---------------------宠物互动-----------------------");
        int health =0;
        int love = 0;
        int pid ;
        try {
            showMyPet();
            System.out.print("请输入你要互动的宠物:");
            pid = sc.nextInt();
            System.out.println("1.给宠物洗澡(健康值+5,亲密度+5)\n" +
                    "2.带宠物去体检(健康值+10,亲密度-5)\n" +
                    "3.给宠物喂食(健康值+7,亲密度+5)\n");
            System.out.print("请选择娱乐项目:");
            int op = sc.nextInt();
            switch (op){
                case 1:
                    health = 5;
                    love = 5;
                    break;
                case 2:
                    health =10;
                    love = -5;
                    break;
                case 3:
                    health = 7;
                    love = 5;
                    break;
                default:
                    System.out.println("没有该选项");
                    break;
            }

            int play = pet.play(health,love,uid,pid);
            if (play>0){
                System.out.println("操作成功,你的宠物情况如下");
                showMyPet();
            }else{
                System.out.println("宠物不想跟你互动,宠物状况如下");
                showMyPet();
            }
        } catch (Exception e) {
            System.out.println("您的输入有误,请重新操作");
            play();
        }
        System.out.println("------------------end-----------------");
    }
    public void showMyUser(){
        System.out.println("----------------您的个人信息--------------------");
        System.out.println("账户编号 账号名称 账号密码 账户余额");
        user.showMyUser(uid);
        System.out.println("------------------end-----------------");
    }
    public  void  showMyOrder(){
        System.out.println("-------------------账单从查询---------------------");
        OrderService osi = new OrderServiceImpl();

        if (uid>0){
            System.out.println("序号\t订单编号\t\t 买家名称 \t\t 卖家名称 \t 交易时间 \t\t\t 交易价格 \t 交易类型");
            osi.showMyOrder(uid);
        }else{
            System.out.println("请先登录");
            login();
        }
        System.out.println("------------------end-----------------");

    }
    public void purchase(){//买的方法
        System.out.println("-----------------宠物购买-----------");
        int buy = user.Buy(uid);
        if (buy>0){
            System.out.println("购买成功,您的宠物信息如下");
            showMyPet();
        }else{
            System.out.println("购买失败,您当前的宠物信息如下");
            showMyUser();
        }
        System.out.println("------------------end-----------------");
    }
//    @Test
    public void sell(){//卖出的方法
        System.out.println("--------------------宠物出售功能----------------------");
        int sell = user.Sell(uid);
        if (sell>0){
            System.out.println("正在记账中...");
            System.out.println("卖出成功!");
        }else{
            System.out.println("交易失败了");
            switch (sell){
                case 0:
                    System.out.println("您没有宠物了哦~");
                    break;
                case -1:
                    System.out.println("您没有该宠物哦~");
                    break;
                case -2:
                    System.out.println("您选择的商家已经破产啦!");
                    break;
                case -3:
                    System.out.println("你的操作有误!");
                    sell();
                    break;
                default:
                    System.out.println("要不重新选择下,可能没有这个商家哦~");
                    break;
            }
        }
        System.out.println("------------------end-----------------");
    }
    public void Urecharge(){
        System.out.println("-------------------个人充值-----------------");
        System.out.print("请输入充值金额:");
        try {
            double money = sc.nextDouble();
            int mrecharg = user.Urecharg(uid, money);
            System.out.println(mrecharg>0?"充值成功":"充值失败");
        } catch (Exception e) {
            System.out.println("你的输入有误(充值金额只能为数字哦)");
            Urecharge();
        }
        System.out.println("------------------end-----------------");
    }
}
