package com.ye.vio.dao;


import com.ye.vio.entity.CollectionTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionTopicDao {

    public List<CollectionTopic> queryCollectionTopicListByUserId(@Param("userId") String userId,
                                                                @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public int insertCollectionTopic(CollectionTopic collectionTopic);

    public CollectionTopic queryCollectionTopic(CollectionTopic collectionTopic);

    public int updateTopicCollectNum(@Param("type")int type, @Param("topicId") String topicId);

    public int deleteCollectionTopic(@Param("userId") String userId, @Param("collectionTopicId") String collectionTopicId);


}
