package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.ReplyLike;
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
public class ReplyLikeDaoTest extends BaseTest {

    @Autowired
   ReplyLikeDao replyLikeDao;
    @Test
    public void testQueryListByUserId(){


    }
    @Test
    public void testUpdate(){
        replyLikeDao.updateReplyNum(1,null,"1");


    }

    @Test
    public void testInsert(){
        ReplyLike replyLike=new ReplyLike();
        replyLike.setReplyLikeId("1");
        replyLike.setCreateTime(new Date());
        replyLike.setLikedFatherReplyId("2");
        replyLike.setUserId("1");
        replyLike.setToUserId("2");
        replyLikeDao.insertReplyLike(replyLike);

    }

    @Test
    public void testDelete(){
        replyLikeDao.deleteReplyLike("1",null,"3");

    }
}
