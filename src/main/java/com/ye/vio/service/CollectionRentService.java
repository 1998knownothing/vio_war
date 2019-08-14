package com.ye.vio.service;


import com.ye.vio.entity.CollectionRent;

import java.util.List;

public interface CollectionRentService {

    public List<CollectionRent> getCollectionRentListByUserId(String userId, int pageIndex, int pageSize);

    public int addCollectionRent(CollectionRent collectionRent);

    public int removeCollectionRent(String userId, String collectionRentId);

}
