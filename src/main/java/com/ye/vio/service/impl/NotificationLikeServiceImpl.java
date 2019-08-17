package com.ye.vio.service.impl;

import com.ye.vio.dao.NotificationLikeDao;
import com.ye.vio.entity.NotificationLike;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.NotificationLikeService;
import com.ye.vio.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: vio
 * @description:点赞提醒服务
 * @author: Mr.liu
 * @create: 2019-08-12 01:16
 **/
@Service
public class NotificationLikeServiceImpl implements NotificationLikeService {


    @Resource
    private NotificationLikeDao notificationLikeDao;

    @Override
    @Transactional
    public List<NotificationLike> getNotificationLikeListByToUserId(String toUserId, int pageIndex, int pageSize) {
        if (toUserId==null||pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        List<NotificationLike>   notificationLikeList;

            notificationLikeList= notificationLikeDao.queryNotificationLikeListByToUserId(toUserId,rowIndex,pageSize);

            if(notificationLikeList!=null&&notificationLikeList.size()>0) {
                int effectedNum = notificationLikeDao.updateNotificationLike(notificationLikeList);
                if (effectedNum < 0) throw new RuntimeException("更新点赞提醒为已读失败");
            }


        return notificationLikeList;
    }
}
