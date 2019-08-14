package com.ye.vio.dao;


import com.ye.vio.entity.CollectionHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionHouseDao {

    public List<CollectionHouse> queryCollectionHouseListByUserId(@Param("userId") String userId,
                                                              @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    public int insertCollectionHouse(CollectionHouse collectionHouse);

    public int deleteCollectionHouse(@Param("userId") String userId, @Param("collectionHouseId") String collectionHouseId);

}
