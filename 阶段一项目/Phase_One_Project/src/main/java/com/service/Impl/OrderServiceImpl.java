package com.service.Impl;

import com.dao.MerchantDao;
import com.dao.PetDao;
import com.dao.UserDao;
import com.dao.impl.MerchantDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.PetDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.pojo.Order;
import com.service.OrderService;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 14:51 2021/8/20
 * @Param Phase_One_Project
 * @Title: 账单业务实现类
 * @Package com.service.Impl
 **/
public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private PetDao pd = new PetDaoImpl();
    private UserDao ud = new UserDaoImpl();
    private MerchantDao md = new MerchantDaoImpl();
    @Override
    public void showMyOrder(@NotNull int id) {
        List<Order> orders = orderDao.showAllOrder(id);
        String bName = null;//定义买家
        String sName = null;//定义卖家
        String pName = null;
        if (orders.size()>0){
            for (int i = 0; i < orders.size(); i++) {
                //输出用户名
                if (orders.get(i).getBuyer_Id()>=1000){//大于1000为用户
                    bName = ud.UName(orders.get(i).getBuyer_Id());
                }else{//小于则为店家id
                    bName = md.MNaem(orders.get(i).getBuyer_Id());
                }
                if(orders.get(i).getSeller_Id()>=1000){//大于1000为用户
                    sName = ud.UName(orders.get(i).getSeller_Id());
                }else{//小于则为店家id
                    sName = md.MNaem(orders.get(i).getSeller_Id());
                }
                pName = pd.PetName(orders.get(i).getPet_Id());//获取宠物名字
                String type = orders.get(i).getO_Type()>1?(orders.get(i).getO_Type()==2?"用户卖给商店":"用户卖给用户"):"商店卖给用户";
                System.out.println((i+1)+"\t"+orders.get(i).getoId()+"\t\t"+bName+"\t\t"+sName+"\t"+orders.get(i).getDeal_Time()+"\t\t"+orders.get(i).getPrice()+"\t"+type);
            }

        }else{
            System.out.println("尚无交易记录");
        }

    }
}
