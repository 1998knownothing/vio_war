package com.ye.vio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-11 20:09
 **/
public class NotificationLike {

    private String notificationLikeId;

    private String fromUserId;

    private String fromNickName;

    private String topicId;

    private String topicContent;

    private String fatherReplyId;

    private String fatherReplyContent;

    private String sonReplyId;

    private String sonReplyContent;

    private String toUserId;

    private String toNickName;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
    private Date createTime;

    private int isRead;

    private int notificationType;

    public String getNotificationLikeId() {
        return notificationLikeId;
    }

    public void setNotificationLikeId(String notificationLikeId) {
        this.notificationLikeId = notificationLikeId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromNickName() {
        return fromNickName;
    }

    public void setFromNickName(String fromNickName) {
        this.fromNickName = fromNickName;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getFatherReplyId() {
        return fatherReplyId;
    }

    public void setFatherReplyId(String fatherReplyId) {
        this.fatherReplyId = fatherReplyId;
    }

    public String getFatherReplyContent() {
        return fatherReplyContent;
    }

    public void setFatherReplyContent(String fatherReplyContent) {
        this.fatherReplyContent = fatherReplyContent;
    }

    public String getSonReplyId() {
        return sonReplyId;
    }

    public void setSonReplyId(String sonReplyId) {
        this.sonReplyId = sonReplyId;
    }

    public String getSonReplyContent() {
        return sonReplyContent;
    }

    public void setSonReplyContent(String sonReplyContent) {
        this.sonReplyContent = sonReplyContent;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getToNickName() {
        return toNickName;
    }

    public void setToNickName(String toNickName) {
        this.toNickName = toNickName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }
}
