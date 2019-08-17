package com.ye.vio.service.impl;

import com.ye.vio.dao.NotificationReplyDao;
import com.ye.vio.entity.NotificationReply;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.NotificationReplyService;
import com.ye.vio.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: vio
 * @description: 评论提醒服务
 * @author: Mr.liu
 * @create: 2019-08-12 01:32
 **/
@Service
public class NotificationReplyServiceImpl implements NotificationReplyService {
    @Resource
    private NotificationReplyDao notificationReplyDao;


    @Override
    @Transactional
    public List<NotificationReply> getNotificationReplyListByToUserId(String toUserId, int pageIndex, int pageSize) {

        if (toUserId==null||pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        List<NotificationReply>   notificationReplyList;

            notificationReplyList= notificationReplyDao.queryNotificationReplyListByToUserId(toUserId,rowIndex,pageSize);

            if(notificationReplyList!=null&&notificationReplyList.size()>0) {
                int effectedNum = notificationReplyDao.updateNotificationReply(notificationReplyList);
                if (effectedNum < 0) throw new RuntimeException("更新评论提醒为已读失败");
            }


        return notificationReplyList;
    }
}
