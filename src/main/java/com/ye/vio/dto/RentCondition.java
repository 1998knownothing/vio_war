package com.ye.vio.dto;

import lombok.Data;

/**
 * @program: vio
 * @description: 求租条件
 * @author: Mr.liu
 * @create: 2019-08-06 22:17
 **/
@Data
public class RentCondition {
    //城市
    private String city;
    //不限0 合租1 整租2
    private int type;
    //区域
    private String area;
    //租金类型
    private int rentalType;
    //关键字  公司名称 地点关键字
    private String keyword;




}
