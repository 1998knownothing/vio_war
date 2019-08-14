package com.ye.vio.service.impl;

import com.ye.vio.dao.RentDao;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.Rent;
import com.ye.vio.service.RentService;
import com.ye.vio.util.PageUtil;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-07 16:09
 **/

@Service
public class RentServiceImpl implements RentService {

    @Resource
    private RentDao rentDao;


    @Override
    public Rent getRentByRentId(String rentId) {
        return rentDao.queryRentByRentId(rentId);
    }

    @Override
    public List<Rent> getRentList(RentCondition rentCondition, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return rentDao.queryRentList(rentCondition,rowIndex,pageSize);
    }

    @Override
    public List<Rent> getRentListByUserId(String userId, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return rentDao.queryRentListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addRent(Rent rent) {
        rent.setRentId(UUIDUtils.UUID());
        UserVo userVo=new UserVo();
        userVo.setUserId("1");
        rent.setUser(userVo);
        rent.setCreateTime(new Date());
        return rentDao.insertRent(rent);
    }

    @Override
    @Transactional
    public int removeRentByRentId(String rentId, String userId) {
        return rentDao.deleteRentByRentId(rentId,userId);
    }
}
