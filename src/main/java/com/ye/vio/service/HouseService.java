package com.ye.vio.service;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.House;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface HouseService {



    public House getHouseByHouseId(String houseId);

    public List<House> getHouseList(RentCondition rentCondition,
                                  int pageIndex, int pageSize);

    public List<House> getHouseListByUserId( String userId,
                                           int pageIndex, int pageSize);

    public int addHouse(House house,List<CommonsMultipartFile> houseImgs);

    public int removeHouseByHouseId(String houseId,String userId);


}
