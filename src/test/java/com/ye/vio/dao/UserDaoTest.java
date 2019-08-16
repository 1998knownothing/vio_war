package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-04 13:40
 **/
public class UserDaoTest extends BaseTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testQueryUserById(){
        User user=userDao.queryUserByAuthToken("01c509ab4a414a1e85db279006820b19");

        System.out.println(user.getNickName());
    }

}
