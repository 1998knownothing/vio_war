package com.ye.vio.service.impl;

import com.ye.vio.dao.ReplyLikeDao;
import com.ye.vio.entity.ReplyLike;
import com.ye.vio.service.ReplyLikeService;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: vio
 * @description: 评论点赞服务
 * @author: Mr.liu
 * @create: 2019-08-11 23:36
 **/
@Service
public class ReplyLikeServiceImpl implements ReplyLikeService {
    @Resource
    private ReplyLikeDao replyLikeDao;

    @Override
    @Transactional
    public int addReplyLike(ReplyLike replyLike) {


        replyLike.setCreateTime(new Date());

        int effected=0;

            effected=replyLikeDao.insertReplyLike(replyLike);

            if(effected<=0)throw new RuntimeException("添加评论点赞失败");

            int effectedUpdate=replyLikeDao.updateReplyNum(1,replyLike.getLikedSonReplyId(),replyLike.getLikedFatherReplyId());

            if (effectedUpdate<=0) throw new RuntimeException("更新评论点赞数失败");



        return effected;
    }

    @Override
    @Transactional
    public int removeReplyLike(ReplyLike replyLike) {


        int effected=0;

            effected=replyLikeDao.deleteReplyLike(replyLike.getUserId(),replyLike.getLikedSonReplyId(),replyLike.getLikedFatherReplyId());

            if(effected<=0)throw new RuntimeException("添加话题点赞失败");

            int effectedUpdate=replyLikeDao.updateReplyNum(2,replyLike.getLikedSonReplyId(),replyLike.getLikedFatherReplyId());

            if (effectedUpdate<=0) throw new RuntimeException("更新话题点赞数失败");


        return effected;
    }
}
