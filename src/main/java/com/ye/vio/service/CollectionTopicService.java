package com.ye.vio.service;


import com.ye.vio.entity.CollectionTopic;


import java.util.List;

public interface CollectionTopicService {

    public List<CollectionTopic> getCollectionTopicListByUserId(String userId, int pageIndex, int pageSize);


    public int addCollectionTopic(CollectionTopic collectionTopic);

    public int removeCollectionTopic(String userId, String collectionTopicId,String topicId);

}
