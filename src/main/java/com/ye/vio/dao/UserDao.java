package com.ye.vio.dao;

import com.ye.vio.entity.User;


/**
 * @program: vio
 * @description: 用户dao
 * @author: Mr.liu
 * @create: 2019-08-04 00:52
 **/
public interface UserDao {

    public User queryUserById(String userId);

    public int updateUser(User user);

    public int insertUser(User user);

}
