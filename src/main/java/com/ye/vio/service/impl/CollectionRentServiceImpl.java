package com.ye.vio.service.impl;

import com.ye.vio.dao.CollectionEmpDao;
import com.ye.vio.dao.CollectionRentDao;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.CollectionRent;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.CollectionEmpService;
import com.ye.vio.service.CollectionRentService;
import com.ye.vio.util.PageUtil;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description: 收藏招聘记录服务
 * @author: Mr.liu
 * @create: 2019-08-12 00:00
 **/
@Service
public class CollectionRentServiceImpl implements CollectionRentService {
    @Resource
    private CollectionRentDao collectionRentDao;

    @Override
    public List<CollectionRent> getCollectionRentListByUserId(String userId, int pageIndex, int pageSize) {
        if (userId==null||pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return collectionRentDao.queryCollectionRentListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addCollectionRent(CollectionRent collectionRent) {
        if (collectionRent.getUserId()==null||collectionRent.getRentVo().getRentId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        if(collectionRentDao.queryCollectionRent(collectionRent)!=null)
            throw new CustomizeException(CustomizeErrorCode.COLLECTION_EXIST);

        collectionRent.setCreateTime(new Date());
        collectionRent.setCollectionRentId(UUIDUtils.UUID());
        int effected=0;

            effected=collectionRentDao.insertCollectionRent(collectionRent);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);

        return effected;

    }

    @Override
    @Transactional
    public int removeCollectionRent(String userId, String collectionRentId) {
        if(userId==null||collectionRentId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        int effected=0;

            effected=collectionRentDao.deleteCollectionRent(userId,collectionRentId);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);


        return effected;
    }
}
