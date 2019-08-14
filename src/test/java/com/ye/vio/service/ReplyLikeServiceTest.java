package com.ye.vio.service;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.ReplyLike;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-11 23:52
 **/
public class ReplyLikeServiceTest extends BaseTest {

    @Autowired
    private ReplyLikeService replyLikeService;
    @Test
    public void test(){

        ReplyLike replyLike=new ReplyLike();
        replyLike.setUserId("1");
        replyLike.setLikedFatherReplyId("1");
        replyLikeService.removeReplyLike(replyLike);
    }
}
