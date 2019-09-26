package com.ye.vio.service;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.TopicLike;
import com.ye.vio.vo.EmploymentVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-04 22:43
 **/
public class TopicLikeServiceTest extends BaseTest {

    @Autowired
    TopicLikeService topicLikeService;

    @Test
    public void testInsert(){
        TopicLike topicLike=new TopicLike();
        topicLike.setUserId("2");
        topicLike.setToUserId("1");
        topicLike.setLikedTopicId("1");

        topicLikeService.addTopicLike(topicLike);
    }

}
