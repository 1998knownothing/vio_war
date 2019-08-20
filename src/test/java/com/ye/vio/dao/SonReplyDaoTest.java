package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.FatherReply;
import com.ye.vio.entity.SonReply;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-18 22:39
 **/
public class SonReplyDaoTest extends BaseTest {

    @Autowired
    private SonReplyDao sonReplyDao;

    @Test
    public void testin(){
        SonReply fatherReply=new SonReply();
        fatherReply.setSonReplyId(UUIDUtils.UUID());

        fatherReply.setTopicId("1");
        UserVo userVo=new UserVo();
        userVo.setUserId("1");
        fatherReply.setFatherReplyId("3");
        fatherReply.setContent("测试添加子评论");
        fatherReply.setCreateTime(new Date());
        fatherReply.setUserVo(userVo);
        fatherReply.setToUserId("2");

        sonReplyDao.insertSonReply(fatherReply);

    }

    @Test
    public void testdelete(){
       sonReplyDao.deleteSonReplyByUserIdAndSonReplyId("1","401ae366e6364985b5ce5fd368b80084");

    }
}
