package com.ye.vio.service.impl;

import com.ye.vio.dao.NotificationLikeDao;
import com.ye.vio.dao.ReplyLikeDao;
import com.ye.vio.entity.NotificationLike;
import com.ye.vio.entity.ReplyLike;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.ReplyLikeService;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description: 评论点赞服务
 * @author: Mr.liu
 * @create: 2019-08-11 23:36
 **/
@Service
public class ReplyLikeServiceImpl implements ReplyLikeService {
    @Resource
    private ReplyLikeDao replyLikeDao;
    @Resource
    private NotificationLikeDao notificationLikeDao;
    @Override
    @Transactional
    public int addReplyLike(ReplyLike replyLike) {

        if (replyLike.getUserId() == null|| replyLike.getToUserId()==null||replyLike.getTopicId()==null) {
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        if(replyLike.getLikedFatherReplyId()==null&&replyLike.getLikedSonReplyId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        if(replyLike.getLikedFatherReplyId()!=null&&replyLike.getLikedSonReplyId()!=null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        //查询是否已经点赞，前端也需要cookie缓存
        List<ReplyLike> replyLikeList=replyLikeDao.queryReplyLikeByReplyIdAndUserId(replyLike);


        if(replyLikeList!=null&&replyLikeList.size()>0)
            throw new CustomizeException(CustomizeErrorCode.REPLY_LIKE_REPEAT_ERROR);//

        replyLike.setReplyLikeId(UUIDUtils.UUID());
        replyLike.setCreateTime(new Date());

        int effected=replyLikeDao.insertReplyLike(replyLike);

            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.REPLY_LIKE_ADD_ERROR);

            int effectedUpdate=replyLikeDao.updateReplyNum(1,replyLike.getLikedSonReplyId(),replyLike.getLikedFatherReplyId());

            if (effectedUpdate<=0) throw new CustomizeException(CustomizeErrorCode.REPLY_UPDATE_ERROR);

        NotificationLike notificationLike=new NotificationLike();
        notificationLike.setNotificationLikeId(UUIDUtils.UUID());
        notificationLike.setFromUserId(replyLike.getUserId());
        notificationLike.setToUserId(replyLike.getToUserId());
        notificationLike.setCreateTime(new Date());
        notificationLike.setTopicId(replyLike.getTopicId());
        notificationLike.setFatherReplyId(replyLike.getLikedFatherReplyId());
        notificationLike.setSonReplyId(replyLike.getLikedSonReplyId());
        if(replyLike.getLikedFatherReplyId()!=null)notificationLike.setNotificationType(2);
        else notificationLike.setNotificationType(3);

            int effectedNoti=notificationLikeDao.insertNotificationLike(notificationLike);

            if(effectedNoti<=0)
                throw new CustomizeException(CustomizeErrorCode.NOTI_LIKE_ADD_ERROR);

        return effected;
    }

    @Override
    @Transactional
    public int removeReplyLike(ReplyLike replyLike) {

        if (replyLike.getUserId() == null) {
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        if(replyLike.getLikedFatherReplyId()==null&&replyLike.getLikedSonReplyId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        if(replyLike.getLikedFatherReplyId()!=null&&replyLike.getLikedSonReplyId()!=null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);


        int effected=replyLikeDao.deleteReplyLike(replyLike.getUserId(),replyLike.getLikedSonReplyId(),replyLike.getLikedFatherReplyId());

            if(effected<=0)throw new CustomizeException(CustomizeErrorCode.REPLY_LIKE_DELETE_ERROR);

            int effectedUpdate=replyLikeDao.updateReplyNum(2,replyLike.getLikedSonReplyId(),replyLike.getLikedFatherReplyId());

            if (effectedUpdate<=0) throw new CustomizeException(CustomizeErrorCode.REPLY_LIKE_UPDATE_REPLY_ERROR);


        return effected;
    }
}
