package com.ye.vio.entity;

import java.util.Date;

/**
 * @program: vio
 * @description: 收藏话题
 * @author: Mr.liu
 * @create: 2019-08-10 22:35
 **/
public class CollectionTopic {

    String collectionTopicId;

    Topic topic;

    String userId;

    Date createTime;

    public String getCollectionTopicId() {
        return collectionTopicId;
    }

    public void setCollectionTopicId(String collectionTopicId) {
        this.collectionTopicId = collectionTopicId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
