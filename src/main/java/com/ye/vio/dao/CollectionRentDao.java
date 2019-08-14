package com.ye.vio.dao;


import com.ye.vio.entity.CollectionRent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionRentDao {

    public List<CollectionRent> queryCollectionRentListByUserId(@Param("userId") String userId,
                                                               @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public int insertCollectionRent(CollectionRent collectionRent);

    public int deleteCollectionRent(@Param("userId") String userId, @Param("collectionRentId") String collectionRentId);


}
