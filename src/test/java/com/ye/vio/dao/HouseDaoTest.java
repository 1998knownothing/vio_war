package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.House;
import com.ye.vio.entity.HouseImg;
import com.ye.vio.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-08 16:19
 **/
public class HouseDaoTest extends BaseTest {


    @Autowired
    HouseDao houseDao;
    @Test
    public void testHouse(){
        House house=houseDao.queryHouseByHouseId("1");
        List<HouseImg> houseImgs=house.getHouseImgList();

        for (HouseImg h:houseImgs
             ) {
            System.out.println(h.getHouseImgAddr());
        }

    }
    @Test
    public void testDeleteHouse1(){
        int e=houseDao.deleteHouseByHouseId("3","1");

            System.out.println("====="+e);


    }

    @Test
    public void testQueryHouseList2(){

        RentCondition rentCondition=new RentCondition();
        rentCondition.setRentalType(2);
        List<House> houses=houseDao.queryHouseList(rentCondition,0,10);
        List<HouseImg> houseImgs=houses.get(1).getHouseImgList();

        for (HouseImg h:houseImgs
        ) {
            System.out.println(h.getHouseImgAddr());
        }

    }

    @Test
    public void testHouseListByUserId3(){

        List<House> houses=houseDao.queryHouseListByUserId("1",0,10);
        List<HouseImg> houseImgs=houses.get(0).getHouseImgList();

        for (HouseImg h:houseImgs
        ) {
            System.out.println(h.getHouseImgAddr());
        }

    }

    @Test
    public void testInsertHouseListByUserId3(){


        House house=new House();
        house.setHouseId("3");
        UserVo userVo=new UserVo();
        userVo.setUserId("1");
        house.setUser(userVo);
        house.setCreateTime(new Date());
        houseDao.insertHouse(house);


    }
}
