package com.service.Impl;


import com.dao.PetDao;
import com.dao.impl.PetDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.pojo.Pet;
import com.pojo.User;
import com.service.MerchantService;
import com.service.PetService;
import com.service.UserService;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

/*
 * @Author 止水
 * @Description //todo
 * @Date 20:04 2021/8/18
 * @Param Phase_One_Project
 * @Title:用户业务逻辑实现类
 * @Package com.service.Impl
 **/
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userdao = new UserDaoImpl();
    private final PetDao petDao = new PetDaoImpl();
    private final PetService petService = new PetServiceImpl();
    private final Scanner sc = new Scanner(System.in);

    private int flag;

    @Override
    public int Login(@NotNull String username, @NotNull String password) {
        int uid = 0;
        User user = userdao.Login(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                uid = user.getUid();
            }
        }
        return uid;

    }


    @Override
    public int Register(@NotNull String username, @NotNull String password) {
        flag = 0;
        int register = userdao.Register(new User(username, password));
        if (register > 0) {
            flag = 1;
        }
        return flag;
    }

    @Override
    public int Update(@NotNull String username, @NotNull String password, @NotNull String oldusername) {
        flag = 0;
        int update = userdao.Update(new User(username, password, oldusername));
        if (update > 0) {
            flag = 1;
        }
        return flag;
    }

    @Override
    public void showUsers() {
        List<User> user = userdao.showUsers();
        if (user != null) {
            for (int i = 0; i < user.size(); i++) {
                System.out.println((i + 1) + "\t" + user.get(i).getUid() + "\t" + user.get(i).getUsername());
            }

        } else {
            System.out.println("当前无用户");
        }
    }

    @Override
    public void showMyUser(@NotNull int id) {
        User user = userdao.showMyUser(id);
        System.out.println(user.getUid() + "\t" + user.getUsername() + "\t" + user.getPassword() + "\t" + user.getMoney());
    }

    @Override
    public int Urecharg(int id, double money) {
        int recharges = userdao.Recharges(id, money);
        return recharges;
    }

    @Override
    public int Buy(int uid) {
//        MerchantMethod merchantMethod = new MerchantMethod();
//        merchantMethod.showMerchant();
//        System.out.print("请选择商铺(请输入商铺编号):");
//        int mid = sc.nextInt();
        petService.showTradable();
        System.out.print("请选择你要购买的宠物(输入序号即可):");
        List<Pet> pets = petDao.showTradable();
        try {
            Pet pet = pets.get((sc.nextInt() - 1));
            int i = petDao.buyPet(pet.getPid(), uid, pet.getMerchant_Id(), pet.getPet_Price());
            if (i > 0) {
                flag = 1;
            }

        } catch (Exception e) {
            System.out.println("你输入的字符有误(序号只能为数字哦),请重新输入");
        }
        return flag;
    }

    @Override
    public int Sell(int uid) {//本次使用return具体参数如下
        /**
         * return 1  交易成功
         * return  0 交易失败 没有宠物了
         * return -1 交易失败 没有该宠物
         * return -2 交易失败 商家余额不足
         * return -3 交易失败 操作有误
         */
        MerchantService merchant = new MerchantServiceImpl();
        System.out.println("序号\t宠物编号\t宠物昵称\t宠物类型\t\t宠物出生日期\t\t健康值\t与宠物的亲密度");
        List<Pet> pets = petDao.showMyPet(uid);
        if (pets.size() != 0) {
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i + 1) + "\t" + pets.get(i).getPid() + "\t" + pets.get(i).getName() + "\t\t" + pets.get(i).getPet_type() + "\t\t" + pets.get(i).getBirthday() + "\t" + pets.get(i).getHealth() + "\t\t " + pets.get(i).getLove());

            }
            int id = 0;
            int pid =0;
            System.out.print("你要卖出的宠物(请输入序号):");
            try {
                id = sc.nextInt();

            } catch (Exception e) {
                System.out.println("您的操作有误哦(宠物编号只能为数字)");
                return -3;

            }
            pid = pets.get(id - 1).getPid();
            double petpeice = pets.get(id-1).getPet_Price();
            System.out.println("序号\t用户id\t用户名");
            merchant.showMerchant();
            System.out.print("请输入回收的商店:");
            int mid = 0;

            try {
                int getmid = sc.nextInt();
                mid = merchant.getMid(getmid);
            } catch (Exception e) {
                System.out.println("您的操作有误哦(商家编号只能为数字)");
                return -3;
            }
            if (mid == 0 || pid == 0)
                return -3;
            else
                flag = petDao.sellPet(pid, uid, mid, petpeice);
            if (flag > 0) {
                return 1;
            } else {
                return -2;
            }

        } else {
            return 0;
        }


    }

}
