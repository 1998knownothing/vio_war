package com.ye.vio.service.impl;

import com.ye.vio.dao.CollectionEmpDao;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.CollectionEmpService;
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
public class CollectionEmpServiceImpl implements CollectionEmpService {
    @Resource
    private CollectionEmpDao collectionEmpDao;

    @Override
    public List<CollectionEmp> getCollectionEmpListByUserId(String userId, int pageIndex, int pageSize) {
        if(userId==null||pageIndex<=0){
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return collectionEmpDao.queryCollectionEmpListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addCollectionEmp(CollectionEmp collectionEmp) {
        if(collectionEmp.getEmploymentVo().getEmploymentId()==null||collectionEmp.getUserId()==null){
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        if(collectionEmpDao.queryCollectionEmp(collectionEmp)!=null)
            throw new CustomizeException(CustomizeErrorCode.COLLECTION_EXIST);
        collectionEmp.setCollectionEmpId(UUIDUtils.UUID());
        collectionEmp.setCreateTime(new Date());
        int effected=0;

            //查询该用户是否收藏此招聘信息

            //否，添加
            effected=collectionEmpDao.insertCollectionEmp(collectionEmp);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);


        return effected;
    }

    @Override
    @Transactional
    public int removeCollectionEmp(String userId, String collectionEmpId) {

        if(userId==null||collectionEmpId==null){
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        int effected=0;

            effected=collectionEmpDao.deleteCollectionEmp(userId,collectionEmpId);
            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.OPERATION_ERROR);

        return effected;
    }
}
