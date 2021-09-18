package com.dao;

import com.pojo.Order;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 14:16 2021/8/20
 * @Param Phase_One_Project
 * @Title: 账单数据处理接口
 * @Package com.dao
 **/
public interface OrderDao {
    List<Order> showAllOrder(int id);//通过id查询账单
//    List<Order> screening(Object... obj);//按条件查询
    int tally(Object... obj);//记账功能
}
