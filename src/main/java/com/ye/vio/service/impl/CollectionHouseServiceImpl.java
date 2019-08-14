package com.ye.vio.service.impl;

import com.ye.vio.dao.CollectionEmpDao;
import com.ye.vio.dao.CollectionHouseDao;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.CollectionHouse;
import com.ye.vio.service.CollectionEmpService;
import com.ye.vio.service.CollectionHouseService;
import com.ye.vio.util.PageUtil;
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
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return collectionHouseDao.queryCollectionHouseListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addCollectionHouse(CollectionHouse collectionHouse) {
        collectionHouse.setCreateTime(new Date());
        return collectionHouseDao.insertCollectionHouse(collectionHouse);
    }

    @Override
    @Transactional
    public int removeCollectionHouse(String userId, String collectionHouseId) {
        return removeCollectionHouse(userId,collectionHouseId);
    }
}
