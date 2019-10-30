package com.ye.vio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: vio
 * @description: 房源图片
 * @author: Mr.liu
 * @create: 2019-08-07 22:16
 **/
public class HouseImg {


    private String houseImgId;

    private String houseId;

    private String houseImgAddr;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
    private Date createTime;

    public String getHouseImgId() {
        return houseImgId;
    }

    public void setHouseImgId(String houseImgId) {
        this.houseImgId = houseImgId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseImgAddr() {
        return houseImgAddr;
    }

    public void setHouseImgAddr(String houseImgAddr) {
        this.houseImgAddr = houseImgAddr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
