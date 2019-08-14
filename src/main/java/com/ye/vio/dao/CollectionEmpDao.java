package com.ye.vio.dao;

import com.ye.vio.entity.CollectionEmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionEmpDao {

    public List<CollectionEmp> queryCollectionEmpListByUserId(@Param("userId")String userId,
                                                              @Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);

    public int insertCollectionEmp(CollectionEmp collectionEmp);

    public int deleteCollectionEmp(@Param("userId")String userId,@Param("collectionEmpId")String collectionEmpId);


}
