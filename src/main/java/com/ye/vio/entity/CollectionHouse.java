package com.ye.vio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ye.vio.vo.HouseVo;

import java.util.Date;

/**
 * @program: vio
 * @description: 房源收藏
 * @author: Mr.liu
 * @create: 2019-08-10 18:13
 **/
public class CollectionHouse {

    private String collectionHouseId;

    private String userId;

    private HouseVo houseVo;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
    private Date createTime;

    public String getCollectionHouseId() {
        return collectionHouseId;
    }

    public void setCollectionHouseId(String collectionHouseId) {
        this.collectionHouseId = collectionHouseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public HouseVo getHouseVo() {
        return houseVo;
    }

    public void setHouseVo(HouseVo houseVo) {
        this.houseVo = houseVo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
