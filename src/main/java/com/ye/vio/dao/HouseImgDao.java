package com.ye.vio.dao;


import com.ye.vio.entity.HouseImg;

import java.util.List;

public interface HouseImgDao {

    List<HouseImg> queryHouseImgList(String houseId);

    int batchInsertHouseImg(List<HouseImg> houseImgList);

    int deleteHouseImgByHouseId(String houseId);
}
