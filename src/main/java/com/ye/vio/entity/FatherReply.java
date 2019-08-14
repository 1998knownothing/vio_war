package com.ye.vio.entity;

import com.ye.vio.vo.UserVo;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description: 父评论
 * @author: Mr.liu
 * @create: 2019-08-09 23:47
 **/
public class FatherReply {

    private String fatherReplyId;

    private String topicId;

    private UserVo userVo;

    private String toUserId;

    private String content;

    private Date createTime;

    private int likeNum;


    private List<SonReply>  sonReplyList;

    public String getFatherReplyId() {
        return fatherReplyId;
    }

    public void setFatherReplyId(String fatherReplyId) {
        this.fatherReplyId = fatherReplyId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public List<SonReply> getSonReplyList() {
        return sonReplyList;
    }

    public void setSonReplyList(List<SonReply> sonReplyList) {
        this.sonReplyList = sonReplyList;
    }
}
