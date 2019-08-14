package com.ye.vio.entity;

import java.util.Date;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-11 18:37
 **/
public class NotificationReply {

    private String notificationReplyId;

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

    private Date createTime;

    private int isRead;

    private int notificationType;

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public String getNotificationReplyId() {
        return notificationReplyId;
    }

    public void setNotificationReplyId(String notificationReplyId) {
        this.notificationReplyId = notificationReplyId;
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

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }
}
