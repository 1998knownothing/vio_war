package com.ye.vio.entity;

import java.util.Date;

/**
 * @program: vio
 * @description: 话题点赞记录
 * @author: Mr.liu
 * @create: 2019-08-11 15:00
 **/
public class TopicLike {


    private String topicLikeId;

    private String userId;

    private String likedTopicId;

    private String toUserId;//接受方

    private Date createTime;

    public String getTopicLikeId() {
        return topicLikeId;
    }

    public void setTopicLikeId(String topicLikeId) {
        this.topicLikeId = topicLikeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLikedTopicId() {
        return likedTopicId;
    }

    public void setLikedTopicId(String likedTopicId) {
        this.likedTopicId = likedTopicId;
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
