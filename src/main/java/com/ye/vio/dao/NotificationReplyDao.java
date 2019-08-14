package com.ye.vio.dao;


import com.ye.vio.entity.NotificationReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotificationReplyDao {

    public List<NotificationReply> queryNotificationReplyListByToUserId(@Param("toUserId")String toUserId,
                                                                  @Param("rowIndex")int rowIndex, @Param("pageSize")int pageSize);

    public int insertNotificationReply(NotificationReply notificationReply);

    public int updateNotificationReply(List<NotificationReply> notificationReplyList);
}
