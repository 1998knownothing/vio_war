package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.CollectionTopic;
import com.ye.vio.entity.Topic;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.EmploymentVo;
import com.ye.vio.vo.UserVo;
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
public class CollectionTopicDaoTest extends BaseTest {

    @Autowired
   CollectionTopicDao collectionTopicDao;
    @Test
    public void testQueryListByUserId(){

        List<CollectionTopic> c=collectionTopicDao.queryCollectionTopicListByUserId("1",0,10);

        System.out.println("==="+c.get(0).getCreateTime());
       //collectionTopicDao.updateTopic(2,"1");
    }


    @Test
    public void testInsert(){
        CollectionTopic c=new CollectionTopic();
        c.setCollectionTopicId("6");
        Topic topic=new Topic();
        topic.setTopicId("3");

        c.setTopic(topic);
        c.setUserId("2");
        c.setCreateTime(new Date());
        collectionTopicDao.insertCollectionTopic(c);

    }

    @Test
    public void testDelete(){
        collectionTopicDao.deleteCollectionTopic("2","6");

    }

    @Test
    public void test(){
        collectionTopicDao.updateTopicCollectNum(1,"5");

    }
}
