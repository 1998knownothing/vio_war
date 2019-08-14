package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.HouseImg;
import org.junit.Test;
import org.junit.runner.notification.RunListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-08 19:14
 **/
public class HouseImgDaoTest extends BaseTest {
    @Autowired
    HouseImgDao houseImgDao;

    @Test
    public void testQuery(){
        houseImgDao.queryHouseImgList("1");
    }

    @Test
    public void testInsert(){
        List<HouseImg> houseImgs=new ArrayList<>();
        HouseImg houseImg1=new HouseImg();
        houseImg1.setHouseId("3");
        houseImg1.setCreateTime(new Date());
        houseImg1.setHouseImgId("5");

        HouseImg houseImg2=new HouseImg();
        houseImg2.setHouseId("3");
        houseImg2.setCreateTime(new Date());
        houseImg2.setHouseImgId("6");

        houseImgs.add(houseImg1);

        houseImgs.add(houseImg2);
        int e=houseImgDao.batchInsertHouseImg(houseImgs);

        System.out.println("========"+e);
        System.out.println("========"+houseImg1.getHouseImgId());
    }
    @Test
    public void testDelete(){
        houseImgDao.deleteHouseImgByHouseId("3");
    }


}
