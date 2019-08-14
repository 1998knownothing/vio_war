package com.ye.vio.dto;

/**
 * @program: vio
 * @description: 求租条件
 * @author: Mr.liu
 * @create: 2019-08-06 22:17
 **/
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


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getRentalType() {
        return rentalType;
    }

    public void setRentalType(int rentalType) {
        this.rentalType = rentalType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


}
