package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionHouse;
import com.ye.vio.entity.CollectionRent;
import com.ye.vio.entity.Rent;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.HouseVo;
import com.ye.vio.vo.RentVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-10 16:52
 **/
public class CollectionRentDaoTest extends BaseTest {

    @Autowired
    CollectionRentDao collectionRentDao;
    @Test
    public void testQueryListByUserId(){
        List<CollectionRent> collectionRents=collectionRentDao.queryCollectionRentListByUserId("1",0,10);

        System.out.println(collectionRents.get(1));

    }


    @Test
    public void testInsert(){
            CollectionRent collectionRent=new CollectionRent();

            collectionRent.setCollectionRentId("4");
            collectionRent.setUserId("2");
        RentVo rentVo=new RentVo();
        rentVo.setRentId("2");
        collectionRent.setRentVo(rentVo);
        collectionRent.setCreateTime(new Date());

        collectionRentDao.insertCollectionRent(collectionRent);
    }

    @Test
    public void testDelete(){
        collectionRentDao.deleteCollectionRent("2","4");
    }

}
