package com.pojo;

/*
 * @Author 止水
 * @Description //
 * @Date 19:24 2021/8/18
 * @Param Phase_One_Project
 * @Title: 订单实体类
 * @Package com.pojo
 **/
public class Order {
    private int oId;
    private int o_Type;
    private int Pet_Id;
    private int seller_Id;
    private int buyer_Id;
    private double Price;
    private String deal_Time;
    private int storeId;

    public Order() {
    }

    public Order(int oId, int o_Type, int pet_Id, int seller_Id, int buyer_Id, double price, String deal_Time, int storeId) {
        this.oId = oId;
        this.o_Type = o_Type;
        Pet_Id = pet_Id;
        this.seller_Id = seller_Id;
        this.buyer_Id = buyer_Id;
        Price = price;
        this.deal_Time = deal_Time;
        this.storeId = storeId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getO_Type() {
        return o_Type;
    }

    public void setO_Type(int o_Type) {
        this.o_Type = o_Type;
    }

    public int getPet_Id() {
        return Pet_Id;
    }

    public void setPet_Id(int pet_Id) {
        Pet_Id = pet_Id;
    }

    public int getSeller_Id() {
        return seller_Id;
    }

    public void setSeller_Id(int seller_Id) {
        this.seller_Id = seller_Id;
    }

    public int getBuyer_Id() {
        return buyer_Id;
    }

    public void setBuyer_Id(int buyer_Id) {
        this.buyer_Id = buyer_Id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDeal_Time() {
        return deal_Time;
    }

    public void setDeal_Time(String deal_Time) {
        this.deal_Time = deal_Time;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", o_Type=" + o_Type +
                ", Pet_Id=" + Pet_Id +
                ", seller_Id=" + seller_Id +
                ", buyer_Id=" + buyer_Id +
                ", Price=" + Price +
                ", deal_Time='" + deal_Time + '\'' +
                ", storeId=" + storeId +
                '}';
    }
}