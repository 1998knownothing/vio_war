package com.ye.vio.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: vio
 * @description: 回复记录点赞
 * @author: Mr.liu
 * @create: 2019-08-11 17:38
 **/

@Data
public class ReplyLike {

    private String replyLikeId;

    private String userId;

    private String likedFatherReplyId;

    private String likedSonReplyId;

    private String toUserId;

    private Date createTime;

   private String topicId;
}
