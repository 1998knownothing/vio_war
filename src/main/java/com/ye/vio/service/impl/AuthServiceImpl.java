package com.ye.vio.service.impl;

import com.ye.vio.dao.AuthDao;
import com.ye.vio.entity.Auth;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
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
        if(id==null){
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        return authDao.queryAuthByAuthId(id);
    }

    @Override
    @Transactional
    public int modifyAuth(Auth auth) {
        if(auth.getAuthId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        int effected=0;

            effected=authDao.updateAuth(auth);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);

        return effected;
    }

    @Override
    @Transactional
    public int addAuth(Auth auth) {
        if(auth==null||auth.getAuthId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int effected=0;

            effected=authDao.insertAuth(auth);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);

        return effected;
    }
}
