package com.pojo;

/*
 * @Author 止水
 * @Description //
 * @Date 19:22 2021/8/18
 * @Param Phase_One_Project
 * @Title: 商户实体类
 * @Package com.pojo
 **/
public class Merchant {
private int mId;
private String Musername;
private String Mpassword;
private double balance;
private String Moldusername;

    public Merchant() {
    }

    public Merchant(String musername, String mpassword) {
        Musername = musername;
        Mpassword = mpassword;
    }

    public Merchant(String musername, String mpassword, String moldusername) {
        Musername = musername;
        Mpassword = mpassword;
        Moldusername = moldusername;
    }

    public Merchant(int mId, String musername, String mpassword, double balance, String moldusername) {

        this.mId = mId;
        Musername = musername;
        Mpassword = mpassword;
        this.balance = balance;
        Moldusername = moldusername;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getMusername() {
        return Musername;
    }

    public void setMusername(String musername) {
        Musername = musername;
    }

    public String getMpassword() {
        return Mpassword;
    }

    public void setMpassword(String mpassword) {
        Mpassword = mpassword;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMoldusername() {
        return Moldusername;
    }

    public void setMoldusername(String moldusername) {
        Moldusername = moldusername;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "mId=" + mId +
                ", Musername='" + Musername + '\'' +
                ", Mpassword='" + Mpassword + '\'' +
                ", balance=" + balance +
                ", Moldusername='" + Moldusername + '\'' +
                '}';
    }
}
