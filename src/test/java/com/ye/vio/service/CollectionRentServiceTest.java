package com.ye.vio.service;

import com.ye.vio.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-04 22:43
 **/
public class CollectionRentServiceTest extends BaseTest {

    @Autowired
    CollectionRentService collectionRentService;

    @Test
    public void testQueryById(){
        collectionRentService.getCollectionRentListByUserId(null,1,10);

    }

}
