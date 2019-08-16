package com.ye.vio.service;

import com.ye.vio.entity.Auth;

public interface AuthService {

    public Auth getAuthByAuthId(String id);


    public int modifyAuth(Auth auth);

    public int addAuth(Auth auth);
}
