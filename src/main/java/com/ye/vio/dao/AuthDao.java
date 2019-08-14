package com.ye.vio.dao;

import com.ye.vio.entity.Auth;

public interface AuthDao {


    public Auth queryAuthByAuthId(String id);

    public int updateAuth(Auth auth);

    public int insertAuth(Auth auth);


}
