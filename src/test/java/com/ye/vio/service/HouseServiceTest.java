package com.ye.vio.service;

import com.ye.vio.BaseTest;
import com.ye.vio.dao.HouseDao;
import com.ye.vio.entity.House;
import com.ye.vio.entity.HouseImg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-09 00:22
 **/
public class HouseServiceTest  extends BaseTest {


    @Autowired
    HouseService houseService;

    @Test
    public void test(){
        House house=houseService.getHouseByHouseId("1");
        List<HouseImg> houseImgs=house.getHouseImgList();

        for (HouseImg h:houseImgs
        ) {
            System.out.println(h.getHouseImgAddr());
        }


    }
}
