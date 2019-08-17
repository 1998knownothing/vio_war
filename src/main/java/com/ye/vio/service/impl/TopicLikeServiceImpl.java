package com.ye.vio.service.impl;

import com.ye.vio.dao.TopicLikeDao;
import com.ye.vio.entity.TopicLike;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: vio
 * @description: 话题点赞服务
 * @author: Mr.liu
 * @create: 2019-08-11 22:40
 **/

@Service
public class TopicLikeServiceImpl implements com.ye.vio.service.TopicLikeService {

    @Resource
    private TopicLikeDao topicLikeDao;


    @Override
    @Transactional
    public int addTopicLike(TopicLike topicLike) {
        topicLike.setTopicLikeId(UUIDUtils.UUID());
        topicLike.setCreateTime(new Date());

        int effected=0;

            effected=topicLikeDao.insertTopicLike(topicLike);

            if(effected<=0)throw new RuntimeException("添加话题点赞失败");

            int effectedUpdate=topicLikeDao.updateTopicLikeNum(1,topicLike.getLikedTopicId());

            if (effectedUpdate<=0) throw new RuntimeException("更新话题点赞数失败");



        return effected;
    }


    @Override
    @Transactional
    public int removeTopicLike(TopicLike topicLike) {
        int effectedDelete=0;

            effectedDelete=topicLikeDao.deleteTopicLike(topicLike.getUserId(),topicLike.getLikedTopicId());

            if(effectedDelete<=0)throw new RuntimeException("删除话题点赞失败");

            int effectedUpdate=topicLikeDao.updateTopicLikeNum(2,topicLike.getLikedTopicId());

            if (effectedUpdate<=0) throw new RuntimeException("更新话题点赞数失败");



        return effectedDelete;
    }
}
