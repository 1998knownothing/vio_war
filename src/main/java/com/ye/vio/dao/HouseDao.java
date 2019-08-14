package com.ye.vio.dao;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.House;
import com.ye.vio.entity.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseDao {


    public House queryHouseByHouseId(String houseId);


    public List<House> queryHouseList(@Param("rentCondition") RentCondition rentCondition,
                                    @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public List<House> queryHouseListByUserId( @Param("userId") String userId,
                                             @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public int insertHouse(House house);

    public int deleteHouseByHouseId(@Param("houseId")String houseId,@Param("userId")String userId);


}
