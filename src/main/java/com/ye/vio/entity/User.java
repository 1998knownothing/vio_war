package com.ye.vio.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: vio
 * @description: 用户实体
 * @author: Mr.liu
 * @create: 2019-08-04 00:41
 **/
@Data
public class User {
    //用户唯一标识符
    private String userId;
    //昵称

    private String nickName;
    //图片地址
    private String imgAddr;
    //邮箱
    private String email;
    //密码
    //性别 1男 2女 3不明
    private int sex;
    //学校
    private String school;
    //公司
    private String company;
    //岗位
    private  String position;
    //联系方式
    private String contact;
    //账号状态
    private int state;
    //激活码
    private String code;
    //账号创建时间
    private Date createTime;


}
