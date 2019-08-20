package com.ye.vio.service.impl;

import com.ye.vio.dao.NotificationLikeDao;
import com.ye.vio.dao.TopicLikeDao;
import com.ye.vio.entity.NotificationLike;
import com.ye.vio.entity.TopicLike;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.NotificationLikeService;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    @Resource
    private NotificationLikeDao notificationLikeDao;



    @Override
    @Transactional
    public int addTopicLike(TopicLike topicLike) {


        if(topicLike.getUserId()==null||topicLike.getToUserId()==null||topicLike.getLikedTopicId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
       List<TopicLike> topicLikeList= topicLikeDao.queryTopicLikeByTopicIdAndUserId(topicLike);
        if(topicLikeList!=null&&topicLikeList.size()>0)
            throw new  CustomizeException(CustomizeErrorCode.TOPIC_LIKE_REPEAT_ERROR);

        topicLike.setTopicLikeId(UUIDUtils.UUID());
        topicLike.setCreateTime(new Date());

        int effected=topicLikeDao.insertTopicLike(topicLike);

            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.TOPIC_LIKE_ADD_ERROR);

            int effectedUpdate=topicLikeDao.updateTopicLikeNum(1,topicLike.getLikedTopicId());

            if (effectedUpdate<=0) throw new CustomizeException(CustomizeErrorCode.TOPIC_LIKE_UPDATE_REPLY_ERROR);

        NotificationLike notificationLike=new NotificationLike();

        notificationLike.setNotificationLikeId(UUIDUtils.UUID());//设置唯一标识
        notificationLike.setTopicId(topicLike.getLikedTopicId());//点赞话题id
        notificationLike.setFromUserId(topicLike.getUserId());//谁点的赞
        notificationLike.setToUserId(topicLike.getToUserId());//给谁
        notificationLike.setNotificationType(1);//什么类型，话题
        notificationLike.setCreateTime(new Date());

       int effectedNoti= notificationLikeDao.insertNotificationLike(notificationLike);

       if(effectedNoti<=0)
           throw new CustomizeException(CustomizeErrorCode.NOTI_LIKE_ADD_ERROR);

        return effected;
    }


    @Override
    @Transactional
    public int removeTopicLike(TopicLike topicLike) {
        if(topicLike.getLikedTopicId()==null||topicLike.getUserId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int effectedDelete=topicLikeDao.deleteTopicLike(topicLike.getUserId(),topicLike.getLikedTopicId());

            if(effectedDelete<=0)throw new CustomizeException(CustomizeErrorCode.TOPIC_LIKE_DELETE_ERROR);

            int effectedUpdate=topicLikeDao.updateTopicLikeNum(2,topicLike.getLikedTopicId());

            if (effectedUpdate<=0) new CustomizeException(CustomizeErrorCode.TOPIC_LIKE_UPDATE_REPLY_ERROR);



        return effectedDelete;
    }
}
