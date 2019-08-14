package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.Rent;
import com.ye.vio.entity.User;
import com.ye.vio.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-07 01:03
 **/
public class RentDaoTest extends BaseTest {
    @Autowired
    RentDao rentDao;

    @Test
    public void testInsert(){
        Rent rent=new Rent();
        UserVo user=new UserVo();
        user.setUserId("1");
        rent.setUser(user);

        rent.setRentId("3");

        rent.setRental("1200");
        rent.setLabel("京东，腾讯");
        rent.setCreateTime(new Date());
        rentDao.insertRent(rent);
    }
    @Test
    public void testDelete(){

        rentDao.deleteRentByRentId("3","1");

    }
    @Test
    public void testQueryById(){

        Rent rent=rentDao.queryRentByRentId("1");
        System.out.println("========="+rent.getUser().getUserId());
    }

    @Test
    public void testQueryByUserId(){

        rentDao.queryRentListByUserId("1",0,10);
       // System.out.println("========="+rent.getUser().getUserId());
    }

    @Test
    public void testQueryListByCondition(){
        RentCondition rentCondition=new RentCondition();
        rentCondition.setRentalType(2);
        rentCondition.setCity("北京");
        rentCondition.setKeyword("抖音");
        List<Rent> list =        rentDao.queryRentList(rentCondition,0,10);
        System.out.println("======"+list.get(0).getUser().getUserId());
        System.out.println("======"+list.get(0).getUser().getNickName());
    }


}
