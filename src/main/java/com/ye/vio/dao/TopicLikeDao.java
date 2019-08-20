package com.ye.vio.dao;


import com.ye.vio.entity.TopicLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TopicLikeDao {


    public int insertTopicLike(TopicLike topicLike);

    public List<TopicLike> queryTopicLikeByTopicIdAndUserId(TopicLike topicLike);

    public int updateTopicLikeNum(@Param("type")int type, @Param("topicId") String topicId);

    public int deleteTopicLike(@Param("userId") String userId, @Param("likedTopicId") String likedTopicId);
}
