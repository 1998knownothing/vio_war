package com.ye.vio.service.impl;

import com.ye.vio.dao.CollectionEmpDao;
import com.ye.vio.dao.CollectionTopicDao;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.CollectionTopic;
import com.ye.vio.service.CollectionEmpService;
import com.ye.vio.service.CollectionTopicService;
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
public class CollectionTopicServiceImpl implements CollectionTopicService {
    @Resource
    private CollectionTopicDao collectionTopicDao;

    @Override
    public List<CollectionTopic> getCollectionTopicListByUserId(String userId, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return collectionTopicDao.queryCollectionTopicListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addCollectionTopic(CollectionTopic collectionTopic) {
        collectionTopic.setCreateTime(new Date());

        int effectedInsert=0;
        try{
            effectedInsert=collectionTopicDao.insertCollectionTopic(collectionTopic);
            if(effectedInsert<=0)throw new RuntimeException("添加话题收藏失败");
            int effectedUpdate=collectionTopicDao.updateTopicCollectNum(1,collectionTopic.getCollectionTopicId());
            if(effectedUpdate<=0)throw new RuntimeException("更新话题收藏数失败++");
        }catch (Exception e){
            throw new RuntimeException("add topic collect failed; "+e.getMessage());
        }
        return effectedInsert;
    }

    @Override
    @Transactional
    public int removeCollectionTopic(String userId, String collectionTopicId) {
        int effectedDelete=0;
        try{
            effectedDelete=removeCollectionTopic(userId,collectionTopicId);
            if(effectedDelete<=0)throw new RuntimeException("添加话题收藏失败");
            int effectedUpdate=collectionTopicDao.updateTopicCollectNum(2,collectionTopicId);
            if(effectedUpdate<=0)throw new RuntimeException("更新话题收藏数失败--");
        }catch (Exception e){
            throw new RuntimeException("add topic collect failed; "+e.getMessage());
        }
        return effectedDelete;
    }
}
