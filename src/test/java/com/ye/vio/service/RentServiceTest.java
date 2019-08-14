package com.ye.vio.service;

import com.ye.vio.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-07 17:15
 **/
public class RentServiceTest extends BaseTest {

    @Autowired
    RentService rentService;

    @Test
    public void test(){
        rentService.getRentListByUserId("1",1,10);

    }
}
