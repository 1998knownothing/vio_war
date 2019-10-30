package com.ye.vio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ye.vio.vo.UserVo;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description: 房源
 * @author: Mr.liu
 * @create: 2019-08-07 22:16
 **/
public class House {

   private String houseId;

   private UserVo user;

   private int type;

   private int houseType;

   private int sex;

   private int state;

   private String city;

   private String area;

   private String address;

   private String rental;

   private String contact;

   private String topic;

   private String note;
    @JsonFormat(pattern="yyyy-MM-dd", locale="zh", timezone="GMT+8")
   private Date createTime;

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

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
