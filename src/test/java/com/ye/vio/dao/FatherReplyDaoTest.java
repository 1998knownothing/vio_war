package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.FatherReply;
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
public class FatherReplyDaoTest extends BaseTest {

    @Autowired
    private FatherReplyDao fatherReplyDao;

    @Test
    public void testin(){
        FatherReply fatherReply=new FatherReply();
        fatherReply.setFatherReplyId(UUIDUtils.UUID());

        fatherReply.setTopicId("1");
        UserVo userVo=new UserVo();
        userVo.setUserId("1");
        fatherReply.setContent("测试添加父评论");
        fatherReply.setCreateTime(new Date());
        fatherReply.setUserVo(userVo);
        fatherReply.setToUserId("1");

        fatherReplyDao.insertFatherReply(fatherReply);

    }

    @Test
    public void testdelete(){
        fatherReplyDao.deleteFatherReplyByUserIdAndFatherReplyId("1","99e3dde2df07471eb72b3525ac7f9cb2");

    }
}
