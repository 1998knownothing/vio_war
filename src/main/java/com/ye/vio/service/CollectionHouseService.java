package com.ye.vio.service;


import com.ye.vio.entity.CollectionHouse;

import java.util.List;

public interface CollectionHouseService {

    public List<CollectionHouse> getCollectionHouseListByUserId(String userId, int pageIndex, int pageSize);

    public int addCollectionHouse(CollectionHouse collectionHouse);

    public int removeCollectionHouse(String userId, String collectionHouseId);

}
