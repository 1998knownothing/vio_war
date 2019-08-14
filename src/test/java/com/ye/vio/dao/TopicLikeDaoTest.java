package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.TopicLike;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.EmploymentVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-10 16:52
 **/
public class TopicLikeDaoTest extends BaseTest {

    @Autowired
    TopicLikeDao topicLikeDao;
    @Test
    public void testUpdate(){
        topicLikeDao.updateTopicLikeNum(2,"1");

    }


    @Test
    public void testInsert(){
        TopicLike topicLike=new TopicLike();

        topicLike.setTopicLikeId("2");
        topicLike.setLikedTopicId("1");
        topicLike.setCreateTime(new Date());
        topicLike.setToUserId("1");
        topicLike.setUserId("2");
        topicLikeDao.insertTopicLike(topicLike);

        topicLikeDao.updateTopicLikeNum(1,"1");


    }

    @Test
    public void testDelete(){

        topicLikeDao.deleteTopicLike("2","3");

        System.out.println();
    }
}
