package com.ye.vio.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-14 15:17
 **/
@Data
public class Auth {

    String id;

    User user;

    String authId;

    String token;

    Date createTime;

}
