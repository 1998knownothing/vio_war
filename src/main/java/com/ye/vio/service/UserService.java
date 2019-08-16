package com.ye.vio.service;

import com.ye.vio.entity.User;

public interface UserService {

    public User getUserById(String userId);

    public User getUserByAuthToken(String token);

    public int modifyUser(User user);

    public int addUser(User user);

}
