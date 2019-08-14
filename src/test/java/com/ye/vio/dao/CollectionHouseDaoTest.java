package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.CollectionHouse;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.EmploymentVo;
import com.ye.vio.vo.HouseVo;
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
public class CollectionHouseDaoTest extends BaseTest {

    @Autowired
    CollectionHouseDao collectionHouseDao;
    @Test
    public void testQueryListByUserId(){

        List<CollectionHouse> collectionHouses=collectionHouseDao.queryCollectionHouseListByUserId("1",0,10);

        System.out.println(collectionHouses.get(0));
    }


    @Test
    public void testInsert(){
        HouseVo houseVo=new HouseVo();
        houseVo.setHouseId("1");
        CollectionHouse collectionHouse=new CollectionHouse();
        collectionHouse.setHouseVo(houseVo);
        collectionHouse.setCollectionHouseId(UUIDUtils.UUID());
        collectionHouse.setUserId("2");
        collectionHouseDao.insertCollectionHouse(collectionHouse);
    }

    @Test
    public void testDelete(){
        collectionHouseDao.deleteCollectionHouse("1","4");
    }
}
