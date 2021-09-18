package com.service.Impl;

import com.dao.PetDao;
import com.dao.impl.PetDaoImpl;
import com.pojo.Pet;
import com.service.PetService;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 19:03 2021/8/19
 * @Param Phase_One_Project
 * @Title: 宠物业务逻辑层实现类
 * @Package com.service.Impl
 **/
public class PetServiceImpl implements PetService {
    private final PetDao petDaoImpl = new PetDaoImpl();
    @Override
    public void showPet() {
        List<Pet> pets = petDaoImpl.showPet();
        if (pets!=null){
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i+1)+"\t"+pets.get(i).getPid()+"\t"+pets.get(i).getName()+"\t\t"+pets.get(i).getPet_type()+"\t"+pets.get(i).getBirthday());
            }

        }
    }



    @Override
    public void showMyPet(@NotNull int id) {
        List<Pet> pets = petDaoImpl.showMyPet(id);
        if (pets.size()>0){
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i+1)+"\t"+pets.get(i).getPid()+"\t"+pets.get(i).getName()+"\t\t"+pets.get(i).getPet_type()+"\t\t"+pets.get(i).getBirthday()+"\t"+pets.get(i).getHealth()+"\t\t "+pets.get(i).getLove());
            }

        }else {
            System.out.println("您当前还没有宠物哦!快去购买吧");
        }
    }

    @Override
    public int play(@NotNull int health,@NotNull int love,@NotNull int uid,@NotNull int id) {
        List<Pet> pets = petDaoImpl.showMyPet(uid);
        int pid = pets.get((id-1)).getPid();
        int play = petDaoImpl.play(health, love, uid,pid);
        return play;
    }



    @Override
    public void showTradable() {
        System.out.println("----------------当前可购买的宠物------------------");
        System.out.println("序号\t宠物编号\t宠物昵称\t宠物类型\t\t宠物出生日期\t\t\t宠物价格");
        List<Pet> pets = petDaoImpl.showTradable();
        if (pets!=null){
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i+1)+"\t"+pets.get(i).getPid()+"\t"+pets.get(i).getName()+"\t\t"+pets.get(i).getPet_type()+"\t\t"+pets.get(i).getBirthday()+"\t\t"+pets.get(i).getPet_Price());

            }

        }
    }


}
