package com.ye.vio.entity;

import com.ye.vio.vo.UserVo;

import java.util.Date;

/**
 * @program: vio
 * @description: 求租
 * @author: Mr.liu
 * @create: 2019-08-06 21:33
 **/
public class Rent {

    //求租唯一标识符
    private String rentId;
    //用户id对应user实体
    private UserVo user;
    //求租类型
    private int type;
    //性别要求
    private int sex;
    //求租信息状态
    private int state;
    //要求城市
    private String city;
    //区域
    private String area;
    //详细地址
    private String address;
    //意向租金
    private String rental;
    //联系方式
    private String contact;
    //详细需求备注
    private String note;
    //创建时间
    private Date createTime;
    //要求公司标签
    private String label;
    //入住时间
    private Date checkInTime;

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
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

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }
}
