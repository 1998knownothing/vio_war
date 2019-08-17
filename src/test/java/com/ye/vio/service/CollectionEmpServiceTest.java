package com.ye.vio.service;

import com.ye.vio.BaseTest;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.entity.Employment;
import com.ye.vio.vo.EmploymentVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-04 22:43
 **/
public class CollectionEmpServiceTest extends BaseTest {

    @Autowired
    CollectionEmpService collectionEmpService;

    @Test
    public void testQueryById(){

        CollectionEmp collectionEmp=new CollectionEmp();
        collectionEmp.setCollectionEmpId("8");
        collectionEmp.setUserId("1");
        EmploymentVo employmentVo=new EmploymentVo();
        employmentVo.setEmploymentId("6");
        collectionEmp.setEmploymentVo(employmentVo);
       collectionEmpService.addCollectionEmp(collectionEmp);

    }

}
