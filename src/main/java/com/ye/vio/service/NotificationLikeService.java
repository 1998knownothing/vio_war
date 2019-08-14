package com.ye.vio.service;


import com.ye.vio.entity.NotificationLike;


import java.util.List;

public interface NotificationLikeService {

    public List<NotificationLike> getNotificationLikeListByToUserId(String toUserId,
                                                                      int pageIndex,int pageSize);

    //public int addNotificationLike(NotificationLike notificationLike);

    //public int updateNotificationLike(List<NotificationLike> notificationLikeList);
}
