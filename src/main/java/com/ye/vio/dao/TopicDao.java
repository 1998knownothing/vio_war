package com.ye.vio.dao;

import com.ye.vio.entity.Topic;
import com.ye.vio.vo.TopicVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicDao {

    public TopicVo queryTopicByTopicId(String topicId);

    public List<Topic> queryTopicList(@Param("keyword")String keyword,@Param("type")int type,
                                       @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public List<Topic> queryTopicListByUserId(@Param("userId")String userId,
                                       @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
    public int insertTopic(Topic topic);

    public int deleteTopic(@Param("topicId")String topicId,@Param("userId")String userId);

    public int updateTopic(Topic topic);

}
