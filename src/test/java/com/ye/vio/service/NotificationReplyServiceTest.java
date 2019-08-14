package com.ye.vio.service;

import com.ye.vio.BaseTest;
import com.ye.vio.dao.NotificationReplyDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-12 01:41
 **/
public class NotificationReplyServiceTest extends BaseTest {

    @Autowired
    private NotificationReplyService notificationReplyService;

    @Test
    public void test(){
        notificationReplyService.getNotificationReplyListByToUserId("2",0,10);
    }
}
