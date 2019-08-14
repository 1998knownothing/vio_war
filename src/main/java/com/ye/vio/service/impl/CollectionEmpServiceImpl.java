package com.ye.vio.service.impl;

import com.ye.vio.dao.CollectionEmpDao;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.service.CollectionEmpService;
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
public class CollectionEmpServiceImpl implements CollectionEmpService {
    @Resource
    private CollectionEmpDao collectionEmpDao;

    @Override
    public List<CollectionEmp> getCollectionEmpListByUserId(String userId, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return collectionEmpDao.queryCollectionEmpListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addCollectionEmp(CollectionEmp collectionEmp) {
        collectionEmp.setCreateTime(new Date());
        return collectionEmpDao.insertCollectionEmp(collectionEmp);
    }

    @Override
    @Transactional
    public int removeCollectionEmp(String userId, String collectionEmpId) {
        return removeCollectionEmp(userId,collectionEmpId);
    }
}
