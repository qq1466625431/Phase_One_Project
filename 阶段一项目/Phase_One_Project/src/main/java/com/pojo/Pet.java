package com.pojo;

/*
 * @Author 止水
 * @Description //
 * @Date 19:16 2021/8/18
 * @Param Phase_One_Project
 * @Title:宠物实体类
 * @Package com.pojo
 **/
public class Pet {
    private int pid;
    private String Name;
    private String Pet_type;
    private int Health;
    private int love;
    private String birthday;
    private int User_Id;
    private int Merchant_Id;
    private  int exchange;
    private double pet_Price;

    public Pet() {
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pid=" + pid +
                ", Name='" + Name + '\'' +
                ", Pet_type='" + Pet_type + '\'' +
                ", Health=" + Health +
                ", love=" + love +
                ", birthday='" + birthday + '\'' +
                ", User_Id=" + User_Id +
                ", Merchant_Id=" + Merchant_Id +
                ", exchange=" + exchange +
                ", pet_Price=" + pet_Price +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPet_type() {
        return Pet_type;
    }

    public void setPet_type(String pet_type) {
        Pet_type = pet_type;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public int getMerchant_Id() {
        return Merchant_Id;
    }

    public void setMerchant_Id(int merchant_Id) {
        Merchant_Id = merchant_Id;
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    public double getPet_Price() {
        return pet_Price;
    }

    public void setPet_Price(double pet_Price) {
        this.pet_Price = pet_Price;
    }

    public Pet(int pid, String name, String pet_type, int health, int love, String birthday, int user_Id, int merchant_Id, int exchange, double pet_Price) {
        this.pid = pid;
        Name = name;
        Pet_type = pet_type;
        Health = health;
        this.love = love;
        this.birthday = birthday;
        User_Id = user_Id;
        Merchant_Id = merchant_Id;
        this.exchange = exchange;
        this.pet_Price = pet_Price;
    }
}
