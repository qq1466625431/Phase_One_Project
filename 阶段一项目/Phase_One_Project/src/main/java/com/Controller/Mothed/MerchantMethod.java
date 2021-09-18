package com.Controller.Mothed;

import com.service.Impl.MerchantServiceImpl;
import com.service.Impl.OrderServiceImpl;
import com.service.OrderService;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/*
 * @Author 止水
 * @Description //todo
 * @Date 11:23 2021/8/20
 * @Param Phase_One_Project
 * @Title: 商家的功能
 * @Package com.Controller
 **/
public class MerchantMethod {
    private  final Scanner sc = new Scanner(System.in);
    private MerchantServiceImpl merchantService = new MerchantServiceImpl();
    private String Mpassword =null;
    private String Musername = null;
    private int mid=0;

    public boolean Mlogin(){
        boolean isLogin = false;
        System.out.println("-----------------商家登录--------------------");
        System.out.print("请输入用户名:");
        Musername = sc.next();
        System.out.print("请输入密码");
        Mpassword = sc.next();
        int mid = merchantService.MLogin(Musername, Mpassword);
        if (mid>0){
            System.out.println("登录成功");
            this.mid =mid;
            isLogin = true;
            showMyInfo();
        }else{
            System.out.println("登陆失败,请重新登录");
            Mlogin();
        }
        System.out.println("------------------end-----------------");
        return isLogin;
    }
    public void showMyInfo(){
        System.out.println("------------您的个人信息-----------");
        System.out.println("用户id\t用户名\t密码\t\t账户金额");
        merchantService.showMyMerchant(mid);
        System.out.println("------------------end-----------------");
    }
//    @Test

    public void Mupdate(){
        System.out.println("--------------信息修改---------------");
//        System.out.println(Musername);
        if (mid>0){
            System.out.println("请输入新的店铺名");
            String usernmae = sc.next();
            System.out.println("请输入新的密码");
            Mpassword = sc.next();
            int update = merchantService.MUpdate(usernmae, Mpassword, Musername);
            if (update>0){
                System.out.println("修改成功,请牢记你的用户名和密码");
            }else{
                System.out.println("修改失败");
            }
        }
        System.out.println("------------------end-----------------");
    }
    public void Morder(){//查看商家账单
       OrderService osi = new OrderServiceImpl();
        System.out.println("------------商家账单从查询----------");
        if (mid>0){
            System.out.println("序号\t订单编号\t\t 买家名称 \t\t 卖家名称 \t 交易时间 \t\t\t 交易价格 \t 交易类型");
           osi.showMyOrder(mid);
        }else{
            System.out.println("请先登录");
            Mlogin();
        }
        System.out.println("------------------end-----------------");
    }
    public void isBuiness(){
        System.out.println("------------------商家注册---------------------");
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        System.out.println("请输入确认密码");
        String password2 = sc.next();
        if (password2.equals(password)){
            int register = merchantService.Register(username, password);
            System.out.println(register>0?"注册成功!":"当前账户已存在");

        }else {
            System.out.println("两次密码不一致,请重新注册");
            isBuiness();
        }
        System.out.println("------------------end-----------------");
    }
    public void Mrecharge(){
        System.out.println("-------------------商家充值-----------------");
        try {
            System.out.println("请输入充值金额");
            double money = sc.nextDouble();
            int mrecharg = merchantService.Mrecharg(mid,money);
            System.out.println(mrecharg>0?"充值成功":"充值失败");
        } catch (Exception e) {
            System.out.println("你输入的字符有误(充值金额只能为数字哦),请重新输入");
            Mrecharge();
        }
        System.out.println("------------------end-----------------");
    }

    public void Breed(){
        System.out.println("---------------------宠物培育-----------------");
        System.out.print("请输入宠物名称:");
        String petName = sc.next();
        System.out.print("请输入宠物类型:");
        String petType = sc.next();
        int health = 0;
        int love = 0;
        double petPrice = 0;
        try {
            System.out.print("请输入宠物健康值:");
            health = sc.nextInt();
            System.out.print("请输入宠物友好度:");
            love = sc.nextInt();
            System.out.print("请输入宠物价格:");
            petPrice = sc.nextDouble();
            int breed = merchantService.Breed(petName, petType, health, love, mid, petPrice);
            System.out.println(breed>0?"培育成功":"宠物名重名了哦");
        } catch (Exception e) {
            System.out.println("你输入的字符有误(健康值,友好度,价格只能为数字哦),请重新输入");
            Breed();
        }

        System.out.println("------------------end-----------------");
    }
    public void showMPet(){
        System.out.println("--------------------您的宠物信息------------------");
        if (mid!=0) {
            System.out.println("序号\t宠物编号\t宠物昵称\t宠物类型\t\t宠物出生日期\t\t健康值\t宠物价格");
                merchantService.showMyMPet(mid);
        }else{
            System.out.println("请先登录");
            Mlogin();
        }
        System.out.println("------------------end-----------------");
    }
}
