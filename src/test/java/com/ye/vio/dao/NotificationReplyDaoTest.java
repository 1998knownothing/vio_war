package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.NotificationReply;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.EmploymentVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-10 16:52
 **/
public class NotificationReplyDaoTest extends BaseTest {

    @Autowired
    NotificationReplyDao notificationReplyDao;
    @Test
    public void testQueryListByUserId(){
        List<NotificationReply> notificationReplies= notificationReplyDao.queryNotificationReplyListByToUserId("2",0,10);

        notificationReplies.get(0);
    }


    @Test
    public void testInsert(){

        NotificationReply n=new NotificationReply();
        n.setNotificationReplyId("2");
        n.setNotificationType(1);
        n.setTopicId("1");
        n.setFromUserId("1");
        n.setToUserId("2");
        n.setCreateTime(new Date());

        notificationReplyDao.insertNotificationReply(n);

    }

    @Test
    public void testUpdate(){
        List<NotificationReply> n=new ArrayList<>();
        NotificationReply notificationReply1=new NotificationReply();
        notificationReply1.setNotificationReplyId("1");
        NotificationReply notificationReply2=new NotificationReply();
        notificationReply2.setNotificationReplyId("2");
        n.add(notificationReply1);
        n.add(notificationReply2);
        int e=notificationReplyDao.updateNotificationReply(n);
        System.out.println(e);

    }
}
