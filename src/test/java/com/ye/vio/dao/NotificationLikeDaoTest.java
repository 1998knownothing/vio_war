package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.NotificationLike;
import com.ye.vio.entity.NotificationReply;
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
public class NotificationLikeDaoTest extends BaseTest {

    @Autowired
    NotificationLikeDao notificationLikeDao;
    @Test
    public void testQueryListByUserId(){
        List<NotificationLike> notificationLikes= notificationLikeDao.queryNotificationLikeListByToUserId("2",0,10);

        notificationLikes.get(0);
    }


    @Test
    public void testInsert(){

        NotificationLike n=new NotificationLike();
        n.setNotificationLikeId("2");
        n.setNotificationType(1);
        n.setTopicId("1");
        n.setFromUserId("1");
        n.setToUserId("2");
        n.setCreateTime(new Date());

        notificationLikeDao.insertNotificationLike(n);

    }

    @Test
    public void testUpdate(){
        List<NotificationLike> n=new ArrayList<>();
        NotificationLike notificationLike1=new NotificationLike();
        notificationLike1.setNotificationLikeId("1");
        NotificationLike notificationLike2=new NotificationLike();
        notificationLike2.setNotificationLikeId("2");
        n.add(notificationLike1);
        n.add(notificationLike2);
        int e=notificationLikeDao.updateNotificationLike(n);
        System.out.println(e);

    }
}
