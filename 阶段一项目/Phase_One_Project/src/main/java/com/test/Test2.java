package com.test;

import com.Controller.Operations;
import com.Controller.PublicMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Scanner;

/*
 * @Author 止水
 * @Description //
 * @Date 11:26 2021/8/19
 * @Param Phase_One_Project
 * @Title:
 * @Package com.test
 **/
public class Test2 {
    private static Logger logger = (Logger) LogManager.getLogger(Test2.class.getName());
    public static void main(String[] args) {
        logger.debug("6666666");
        logger.info("2222222");
        Operations ops = new Operations();
        PublicMethods pm = new PublicMethods();
        pm.showMerchant();
        pm.showPet();
        pm.showUsers();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择(1.买家系统;2.商家系统)");
            int opid = sc.nextInt();
            switch (opid) {
                case 1:
                    ops.User();
                    break;
                case 2:
                    ops.Merchant();
                    break;
                default:
                    System.out.println("没有该选项");
                    break;
            }
        }

    }
}
