package com.ye.vio.vo;

import com.ye.vio.entity.HouseImg;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:收藏的房源信息显示
 * @author: Mr.liu
 * @create: 2019-08-10 18:18
 **/
public class HouseVo {

    private String houseId;

    private String userId;

    private int type;

    private int houseType;

    private int sex;

    private int state;

    private String address;

    private String rental;

    private String topic;

    private String label;

    private List<HouseImg> houseImgList;

    public List<HouseImg> getHouseImgList() {
        return houseImgList;
    }

    public void setHouseImgList(List<HouseImg> houseImgList) {
        this.houseImgList = houseImgList;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHouseType() {
        return houseType;
    }

    public void setHouseType(int houseType) {
        this.houseType = houseType;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
