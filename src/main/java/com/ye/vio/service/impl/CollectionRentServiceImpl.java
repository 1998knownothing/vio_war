package com.ye.vio.service.impl;

import com.ye.vio.dao.CollectionEmpDao;
import com.ye.vio.dao.CollectionRentDao;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.CollectionRent;
import com.ye.vio.service.CollectionEmpService;
import com.ye.vio.service.CollectionRentService;
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
public class CollectionRentServiceImpl implements CollectionRentService {
    @Resource
    private CollectionRentDao collectionRentDao;

    @Override
    public List<CollectionRent> getCollectionRentListByUserId(String userId, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return collectionRentDao.queryCollectionRentListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addCollectionRent(CollectionRent collectionRent) {
        collectionRent.setCreateTime(new Date());
        return collectionRentDao.insertCollectionRent(collectionRent);
    }

    @Override
    @Transactional
    public int removeCollectionRent(String userId, String collectionRentId) {
        return removeCollectionRent(userId,collectionRentId);
    }
}
