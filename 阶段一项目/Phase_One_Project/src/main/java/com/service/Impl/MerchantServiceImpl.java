package com.service.Impl;

import com.dao.PetDao;
import com.dao.impl.MerchantDaoImpl;
import com.dao.impl.PetDaoImpl;
import com.pojo.Merchant;
import com.pojo.Pet;
import com.service.MerchantService;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
 * @Author 止水
 * @Description //todo
 * @Date 11:08 2021/8/20
 * @Param Phase_One_Project
 * @Title: 商家业务逻辑实现类
 * @Package com.service.Impl
 **/
public class MerchantServiceImpl implements MerchantService {
    private Merchant merchant = new Merchant();
    private MerchantDaoImpl merchantDao = new MerchantDaoImpl();
    private PetDao petDao = new PetDaoImpl();
    private int flag;

    @Override
    public int MLogin(@NotNull String username, @NotNull String password) {
        Merchant mLogin = merchantDao.MLogin(username);
        int mid=0;
        if (mLogin!=null){
            if (mLogin.getMpassword().equals(password)){
                mid = mLogin.getmId();
            }
        }
        return mid;
    }

    @Override
    public int MUpdate(@NotNull String username, @NotNull String password, @NotNull String oldusername) {
        flag = 0;
        int update = merchantDao.MUpdate(new Merchant(username, password, oldusername));
        if (update>0){
            flag=1;
        }
        return flag;
    }

    @Override
    public void showMerchant() {
        List<Merchant> merchants = merchantDao.showMerchant();

        if (merchants!=null){
            for (int i = 0; i < merchants.size(); i++) {
                System.out.println((i+1)+"\t"+merchants.get(i).getmId()+"\t\t"+merchants.get(i).getMusername());
            }

        }

    }
    @Override
    public int getMid(int id){
        List<Merchant> merchants = merchantDao.showMerchant();
        int getmId = 0;
        if (merchants!=null){
            for (int i = 0; i < merchants.size(); i++) {
                 getmId= merchants.get((id - 1)).getmId();
            }

        }
        return getmId;
    }

    @Override
    public void showMyMerchant(@NotNull int mid) {
        Merchant merchant = merchantDao.showMyMerchant(mid);
        System.out.println(merchant.getmId()+"\t\t"+merchant.getMusername()+"\t"+merchant.getMpassword()+"\t"+merchant.getBalance());
    }

    @Override
    public int Breed(@NotNull Object... obj) {
        int breed = merchantDao.Breed(obj);
        return breed;
    }


    @Override
    public void showMyMPet(int mid) {
            List<Pet> pets = petDao.showMyMPet(mid);
            if (pets!=null){
                int i =1;
                for (Pet pet : pets) {
                    System.out.println(i+"\t"+pet.getPid()+"\t"+pet.getName()+"\t\t"+pet.getPet_type()+
                            "\t\t"+pet.getBirthday()+"\t\t"+pet.getHealth()+"\t"+pet.getPet_Price());

                i++;
                }
            }

    }

    @Override
    public int UpdatePet(@NotNull Object... obj) {
        flag = 0;
        int i = petDao.UpdatePet(obj);
        if (i>0){
            flag=1;
        }
        return flag;
    }

    @Override
    public int Mrecharg(int id, double money) {
        int recharges = merchantDao.Recharges(id, money);
        return recharges;
    }

    @Override
    public int Register(String musername,String password) {
        Merchant merchant = new Merchant(musername,password);
        int register = merchantDao.Register(merchant);
        return register;
    }

}
