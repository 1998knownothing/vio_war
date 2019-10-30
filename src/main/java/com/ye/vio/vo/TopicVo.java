package com.ye.vio.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ye.vio.entity.FatherReply;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:详细页面数据
 * @author: Mr.liu
 * @create: 2019-08-09 22:43
 **/
public class TopicVo {

    private String topicId;

    private UserVo userVo;

    private int type;

    private String resumeImg;

    private String content;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
    private Date createTime;

    private int collectNum;

    private int likeNum;

    private int commentNum;

    private List<FatherReply> fatherReplyList;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getResumeImg() {
        return resumeImg;
    }

    public void setResumeImg(String resumeImg) {
        this.resumeImg = resumeImg;
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

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public List<FatherReply> getFatherReplyList() {
        return fatherReplyList;
    }

    public void setFatherReplyList(List<FatherReply> fatherReplyList) {
        this.fatherReplyList = fatherReplyList;
    }
}
