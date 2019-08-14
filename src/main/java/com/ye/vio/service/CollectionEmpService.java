package com.ye.vio.service;

import com.ye.vio.entity.CollectionEmp;


import java.util.List;

public interface CollectionEmpService {

    public List<CollectionEmp> getCollectionEmpListByUserId(String userId,int pageIndex,int pageSize);

    public int addCollectionEmp(CollectionEmp collectionEmp);

    public int removeCollectionEmp(String userId,String collectionEmpId);

}
