package com.ye.vio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ye.vio.vo.RentVo;

import java.util.Date;

/**
 * @program: vio
 * @description: 求租信息
 * @author: Mr.liu
 * @create: 2019-08-10 21:39
 **/
public class CollectionRent {

    String collectionRentId;

    String userId;

    RentVo rentVo;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
    Date createTime;

    public String getCollectionRentId() {
        return collectionRentId;
    }

    public void setCollectionRentId(String collectionRentId) {
        this.collectionRentId = collectionRentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RentVo getRentVo() {
        return rentVo;
    }

    public void setRentVo(RentVo rentVo) {
        this.rentVo = rentVo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
