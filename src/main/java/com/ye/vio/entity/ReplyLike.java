package com.ye.vio.entity;

import java.util.Date;

/**
 * @program: vio
 * @description: 回复记录点赞
 * @author: Mr.liu
 * @create: 2019-08-11 17:38
 **/
public class ReplyLike {

    private String replyLikeId;

    private String userId;

    private String likedFatherReplyId;

    private String likedSonReplyId;

    private String toUserId;

    private Date createTime;

    public String getReplyLikeId() {
        return replyLikeId;
    }

    public void setReplyLikeId(String replyLikeId) {
        this.replyLikeId = replyLikeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLikedFatherReplyId() {
        return likedFatherReplyId;
    }

    public void setLikedFatherReplyId(String likedFatherReplyId) {
        this.likedFatherReplyId = likedFatherReplyId;
    }

    public String getLikedSonReplyId() {
        return likedSonReplyId;
    }

    public void setLikedSonReplyId(String likedSonReplyId) {
        this.likedSonReplyId = likedSonReplyId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
