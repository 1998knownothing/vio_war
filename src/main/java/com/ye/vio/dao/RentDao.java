package com.ye.vio.dao;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: vio
 * @description: 求租模块dao
 * @author: Mr.liu
 * @create: 2019-08-06 21:48
 **/
public interface RentDao {

    public Rent queryRentByRentId(String rentId);

    public List<Rent> queryRentList(@Param("rentCondition") RentCondition rentCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public List<Rent> queryRentListByUserId( @Param("userId") String userId,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public int insertRent(Rent rent);

    public int deleteRentByRentId(@Param("rentId")String rentId,@Param("userId")String userId);
}
