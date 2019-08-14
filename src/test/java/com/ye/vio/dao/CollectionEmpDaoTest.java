package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.EmploymentVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-10 16:52
 **/
public class CollectionEmpDaoTest  extends BaseTest {

    @Autowired
    CollectionEmpDao collectionEmpDao;
    @Test
    public void testQueryListByUserId(){

        List<CollectionEmp> collectionEmps= collectionEmpDao.queryCollectionEmpListByUserId("1",0,10);

        System.out.println(collectionEmps.get(0));
    }


    @Test
    public void testInsert(){


        CollectionEmp collectionEmp=new CollectionEmp();

        collectionEmp.setCollectionEmpId(UUIDUtils.UUID());
        collectionEmp.setUserId("2");
        collectionEmp.setCreateTime(new Date());
        EmploymentVo employmentVo=new EmploymentVo();
        employmentVo.setEmploymentId("2");
        collectionEmp.setEmploymentVo(employmentVo);
       int e= collectionEmpDao.insertCollectionEmp(collectionEmp);

        System.out.println(e);
    }

    @Test
    public void testDelete(){

        List<CollectionEmp> collectionEmps= collectionEmpDao.queryCollectionEmpListByUserId("1",0,10);

        System.out.println(collectionEmps.get(0));
    }
}
