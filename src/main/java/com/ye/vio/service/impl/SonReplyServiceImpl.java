package com.ye.vio.service.impl;

import com.ye.vio.dao.FatherReplyDao;
import com.ye.vio.dao.NotificationReplyDao;
import com.ye.vio.dao.SonReplyDao;
import com.ye.vio.entity.NotificationReply;
import com.ye.vio.entity.SonReply;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.SonReplyService;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-19 01:11
 **/
@Service
public class SonReplyServiceImpl implements SonReplyService {

    @Resource
    private FatherReplyDao fatherReplyDao;
    @Resource
    private SonReplyDao sonReplyDao;
    @Resource
    private NotificationReplyDao notificationReplyDao;

    @Override
    @Transactional
    public int addSonReply(SonReply sonReply) {
        if(sonReply.getUserVo().getUserId()==null
                ||sonReply.getToUserId()==null
                ||sonReply.getFatherReplyId()==null
                ||sonReply.getTopicId()==null
                ||sonReply.getContent()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        sonReply.setSonReplyId(UUIDUtils.UUID());
        sonReply.setCreateTime(new Date());

        int effectedAdd=sonReplyDao.insertSonReply(sonReply);

        if(effectedAdd<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_ADD_ERROR);

        int effectedUpdate=fatherReplyDao.updateTopicCommentNum(1,sonReply.getTopicId());

        if(effectedUpdate<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_ADD_ERROR);

        //通知话题发布者，收到子评论
        NotificationReply notificationReply=new NotificationReply();
        notificationReply.setNotificationReplyId(UUIDUtils.UUID());
        notificationReply.setFromUserId(sonReply.getUserVo().getUserId());
        notificationReply.setToUserId(sonReply.getToUserId());
        notificationReply.setNotificationType(3);//属于 某回复了你的评论
        notificationReply.setCreateTime(new Date());
        notificationReply.setTopicId(sonReply.getTopicId());
        notificationReply.setFatherReplyId(sonReply.getFatherReplyId());
        notificationReply.setSonReplyId(sonReply.getSonReplyId());

        notificationReplyDao.insertNotificationReply(notificationReply);

        return effectedAdd;
    }

    @Override
    @Transactional
    public int removeSonReplyByUserIdAndSonReplyId(String userId, String sonReplyId, String topicId) {
        if(userId==null||sonReplyId==null||topicId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int effectedDelete=sonReplyDao.deleteSonReplyByUserIdAndSonReplyId(userId,sonReplyId);

        if(effectedDelete<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_DELETE_ERROR);

        int effectedUpdate=fatherReplyDao.updateTopicCommentNum(2,topicId);

        if(effectedUpdate<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_UPDATE_ERROR);

        return effectedDelete;
    }
}
