package com.ye.vio.service;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentService {


    public Rent getRentByRentId(String rentId);

    public List<Rent> getRentList(RentCondition rentCondition,
                                    int pageIndex, int pageSize);

    public List<Rent> getRentListByUserId( String userId,
                                            int pageIndex, int pageSize);

    public int addRent(Rent rent);

    public int removeRentByRentId(String rentId,String userId);



}
