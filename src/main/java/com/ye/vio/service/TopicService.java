package com.ye.vio.service;

import com.ye.vio.entity.Topic;
import com.ye.vio.vo.TopicVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface TopicService {

    public TopicVo getTopicByTopicId(String topicId);

    public List<Topic> getTopicList(String keyword, int type,
                                     int pageIndex, int pageSize);

    public List<Topic> getTopicListByUserId(String userId,
                                               int pageIndex, int pageSize);
    public int addTopic(Topic topic, CommonsMultipartFile file);

    public int removeTopic(String topicId,String userId);

}
