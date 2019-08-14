package com.ye.vio.service;


import com.ye.vio.entity.NotificationReply;


import java.util.List;

public interface NotificationReplyService {

    public List<NotificationReply> getNotificationReplyListByToUserId(String toUserId,
                                                                        int pageIndex,int pageSize);

    //public int addNotificationReply(NotificationReply notificationReply);

    //public int modifyNotificationReply(List<NotificationReply> notificationReplyList);
}
