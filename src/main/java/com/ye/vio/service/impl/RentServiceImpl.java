package com.ye.vio.service.impl;

import com.ye.vio.dao.RentDao;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.Rent;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
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
        if (pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return rentDao.queryRentList(rentCondition,rowIndex,pageSize);
    }

    @Override
    public List<Rent> getRentListByUserId(String userId, int pageIndex, int pageSize) {
        if (userId==null||pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return rentDao.queryRentListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addRent(Rent rent) {
        if (rent.getUser().getUserId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        rent.setRentId(UUIDUtils.UUID());
        rent.setCreateTime(new Date());
        int effected=rentDao.insertRent(rent);
        if(effected<=0)throw new CustomizeException(CustomizeErrorCode.RENT_ADD_ERROR);

        return effected;
    }

    @Override
    @Transactional
    public int removeRentByRentId(String rentId, String userId) {
        if (rentId==null||userId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        int effected=rentDao.deleteRentByRentId(rentId,userId);
        if(effected<=0)throw new CustomizeException(CustomizeErrorCode.RENT_DELETE_ERROR);

        return effected;
    }
}
