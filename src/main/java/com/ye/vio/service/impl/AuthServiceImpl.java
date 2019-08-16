package com.ye.vio.service.impl;

import com.ye.vio.dao.AuthDao;
import com.ye.vio.entity.Auth;
import com.ye.vio.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-16 13:19
 **/
@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private AuthDao authDao;
    @Override
    public Auth getAuthByAuthId(String id) {
        return authDao.queryAuthByAuthId(id);
    }

    @Override
    @Transactional
    public int modifyAuth(Auth auth) {
        return authDao.updateAuth(auth);
    }

    @Override
    @Transactional
    public int addAuth(Auth auth) {
        return authDao.insertAuth(auth);
    }
}
