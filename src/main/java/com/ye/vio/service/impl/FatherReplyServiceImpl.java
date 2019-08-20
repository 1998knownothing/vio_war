package com.ye.vio.service.impl;

import com.ye.vio.dao.FatherReplyDao;
import com.ye.vio.dao.NotificationReplyDao;
import com.ye.vio.entity.FatherReply;
import com.ye.vio.entity.NotificationReply;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.FatherReplyService;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: vio
 * @description:父评论服务
 * @author: Mr.liu
 * @create: 2019-08-19 00:45
 **/
@Service
public class FatherReplyServiceImpl implements FatherReplyService {

    @Resource
    private FatherReplyDao fatherReplyDao;
    @Resource
    private NotificationReplyDao notificationReplyDao;

    @Override
    @Transactional
    public int addFatherReply(FatherReply fatherReply) {
        if(fatherReply.getUserVo().getUserId()==null||
                fatherReply.getContent()==null||
                fatherReply.getTopicId()==null||
                fatherReply.getToUserId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        fatherReply.setFatherReplyId(UUIDUtils.UUID());
        fatherReply.setCreateTime(new Date());

        int effectedAdd=fatherReplyDao.insertFatherReply(fatherReply);

        if(effectedAdd<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_ADD_ERROR);

        int effectedUpdate=fatherReplyDao.updateTopicCommentNum(1,fatherReply.getTopicId());

        if(effectedUpdate<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_LIKE_UPDATE_REPLY_ERROR);

        //通知话题发布者，收到父评论
        NotificationReply notificationReply=new NotificationReply();
        notificationReply.setNotificationReplyId(UUIDUtils.UUID());
        notificationReply.setFromUserId(fatherReply.getUserVo().getUserId());
        notificationReply.setToUserId(fatherReply.getToUserId());
        notificationReply.setNotificationType(2);//属于 某评论了你的话题
        notificationReply.setCreateTime(new Date());
        notificationReply.setTopicId(fatherReply.getTopicId());
        notificationReply.setFatherReplyId(fatherReply.getFatherReplyId());

        notificationReplyDao.insertNotificationReply(notificationReply);

        return effectedAdd;
    }

    @Override
    @Transactional
    public int removeFatherReplyByUserIdAndFatherReplyId(String userId, String fatherReplyId,String topicId) {
        if(userId==null||fatherReplyId==null||topicId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int effectedDelete=fatherReplyDao.deleteFatherReplyByUserIdAndFatherReplyId(userId,fatherReplyId);

        if(effectedDelete<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_DELETE_ERROR);

        int effectedUpdate=fatherReplyDao.updateTopicCommentNum(2,topicId);

        if(effectedUpdate<=0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_UPDATE_ERROR);

        return effectedDelete;
    }
}
