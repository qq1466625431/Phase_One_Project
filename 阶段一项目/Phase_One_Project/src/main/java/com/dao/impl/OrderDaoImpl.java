package com.dao.impl;

import com.dao.OrderDao;
import com.pojo.Order;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

/*
 * @Author 止水
 * @Description //
 * @Date 14:20 2021/8/20
 * @Param Phase_One_Project
 * @Title:账单数据处理实现类
 * @Package com.dao.impl
 **/
public class OrderDaoImpl implements OrderDao {
    private String sql ;
    private  final QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

    @Override
    public List<Order> showAllOrder(@NotNull int id) {
        sql = "select * from orders where seller_id=? or buyer_id=?";
        List<Order> orderList = null;
        try {
            orderList= qr.query(sql, new BeanListHandler<Order>(Order.class),id,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public int tally(Object... obj) {
        sql = "insert into orders(o_type,pet_id,seller_id,buyer_id,price) values(?,?,?,?,?)";
        int tally = 0;
        try {
            tally = qr.update(sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tally;
    }

//    @Override
//    public List<Order> screening(Object... obj) {
//        sql="select * from `order` where ?=? and (seller_id=? or buyer_id=?)";
//        List<Order> orderList = null;
//        try {
//            orderList = qr.query(sql,new BeanListHandler<Order>(Order.class),obj);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return orderList;
//    }
}
