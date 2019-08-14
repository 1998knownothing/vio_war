package com.ye.vio.dao;


import com.ye.vio.entity.NotificationLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotificationLikeDao {

    public List<NotificationLike> queryNotificationLikeListByToUserId(@Param("toUserId") String toUserId,
                                                                       @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public int insertNotificationLike(NotificationLike notificationLike);

    public int updateNotificationLike(List<NotificationLike> notificationLikeList);
}
