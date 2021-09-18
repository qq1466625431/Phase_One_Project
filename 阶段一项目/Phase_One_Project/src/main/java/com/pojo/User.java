package com.pojo;

/*
 * @Author 止水
 * @Description //
 * @Date 19:15 2021/8/18
 * @Param Phase_One_Project
 * @Title:主人实体类
 * @Package com.pojo
 **/
public class User {
    private int Uid;
    private String username;
    private String password;
    private double money;
    private String oldusername;

    public User() {
    }

    public User(int uid, String username, String password, double money) {
        Uid = uid;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public User(String username, String password, String oldusername) {
        this.username = username;
        this.password = password;
        this.oldusername = oldusername;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getOldusername() {
        return oldusername;
    }

    public void setOldusername(String oldusername) {
        this.oldusername = oldusername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "Uid=" + Uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
