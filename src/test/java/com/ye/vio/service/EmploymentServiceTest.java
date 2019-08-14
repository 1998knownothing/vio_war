package com.ye.vio.service;

import com.ye.vio.BaseTest;
import com.ye.vio.dao.EmploymentDao;
import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.entity.Employment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-04 22:43
 **/
public class EmploymentServiceTest extends BaseTest {

    @Autowired
    EmploymentService employmentService;

    @Test
    public void testQueryById(){
        employmentService.getEmploymentByEmploymentId("1");

    }

    @Test
    public void testDeleteById(){
       employmentService.removeEmploymentByEmploymentId("5","1");

    }
}
