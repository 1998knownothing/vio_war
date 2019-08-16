package com.ye.vio.service.impl;

import com.ye.vio.dao.UserDao;
import com.ye.vio.entity.User;
import com.ye.vio.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-16 13:06
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(String userId) {
        return userDao.queryUserById(userId);
    }

    @Override
    public User getUserByAuthToken(String token) {
        return userDao.queryUserByAuthToken(token);
    }

    @Override
    @Transactional
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public int addUser(User user) {
        return userDao.insertUser(user);
    }
}
