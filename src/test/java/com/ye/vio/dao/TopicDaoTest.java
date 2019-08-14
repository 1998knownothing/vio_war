package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.FatherReply;
import com.ye.vio.entity.SonReply;
import com.ye.vio.entity.Topic;
import com.ye.vio.vo.TopicVo;
import com.ye.vio.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-09 21:35
 **/
public class TopicDaoTest extends BaseTest {

    @Autowired
    TopicDao topicDao;

    @Test
    public void testQueryByTopicId(){

        TopicVo topicVo=topicDao.queryTopicByTopicId("2");

        System.out.println(topicVo.getTopicId());

        List<FatherReply> fatherReplyList=topicVo.getFatherReplyList();
        for (FatherReply f:fatherReplyList){
            System.out.println("======"+f.getContent());

        }

        List<SonReply> sonReplyList=fatherReplyList.get(0).getSonReplyList();

        for (SonReply s:sonReplyList)
        {
            System.out.println("+++++"+s.getContent());
        }

    }

    @Test
    public void test(){

        topicDao.queryTopicListByUserId("1",1,0,10);

    }

    @Test
    public void testInsert(){


        Topic topic=new Topic();
        UserVo userVo=new UserVo();
        userVo.setUserId("1");
        topic.setTopicId("4");
        topic.setUserVo(userVo);
        topic.setType(1);
        topic.setContent("我测试一下！！！");
        topic.setCreateTime(new Date());
        topicDao.insertTopic(topic);

    }

    @Test
    public void testQueryList(){

        topicDao.queryTopicList(null,1,0,10);

    }



}
