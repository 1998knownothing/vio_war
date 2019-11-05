package com.ye.vio.service.impl;

import com.ye.vio.dao.CollectionEmpDao;
import com.ye.vio.dao.CollectionHouseDao;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.CollectionHouse;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.CollectionEmpService;
import com.ye.vio.service.CollectionHouseService;
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
public class CollectionHouseServiceImpl implements CollectionHouseService {
    @Resource
    private CollectionHouseDao collectionHouseDao;

    @Override
    public List<CollectionHouse> getCollectionHouseListByUserId(String userId, int pageIndex, int pageSize) {
        if(userId==null||pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return collectionHouseDao.queryCollectionHouseListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addCollectionHouse(CollectionHouse collectionHouse) {
        if(collectionHouse.getUserId()==null||collectionHouse.getHouseVo().getHouseId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        if(collectionHouseDao.queryCollectionHouse(collectionHouse)!=null)
            throw  new CustomizeException(CustomizeErrorCode.COLLECTION_EXIST);

        collectionHouse.setCollectionHouseId(UUIDUtils.UUID());
        collectionHouse.setCreateTime(new Date());
        int effected=0;

            effected=collectionHouseDao.insertCollectionHouse(collectionHouse);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);

        return effected;

    }

    @Override
    @Transactional
    public int removeCollectionHouse(String userId, String collectionHouseId) {
        if(userId==null||collectionHouseId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int effected=0;

            effected=collectionHouseDao.deleteCollectionHouse(userId,collectionHouseId);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);

        return effected;

    }
}
