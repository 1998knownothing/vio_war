package com.ye.vio.dao;

import com.ye.vio.BaseTest;
import com.ye.vio.dto.EmploymentCondition;
import com.ye.vio.entity.Employment;
import com.ye.vio.entity.User;
import com.ye.vio.util.ImageUtil;
import com.ye.vio.util.UUIDUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-04 13:40
 **/
public class EmploymentDaoTest extends BaseTest {
    @Autowired
    EmploymentDao employmentDao;


    @Test
    public void testQuery1ById(){
        Employment employment =employmentDao.queryEmploymentByEmploymentId("8c8751454bf047deace9874a65b5b4fa");
        ImageUtil.deleteFile(employment.getCompanyLogo());

    }

    @Test
    public void testQueryById(){
        Employment employment =employmentDao.queryEmploymentByEmploymentId("1");
        System.out.println(employment.getResumeFormat());

    }
    @Test
    public void testQueryByUserId(){
        employmentDao.queryEmploymentListByUserId("1",0,10);


    }
    @Test
    public void test(){
        List<String> lists=new ArrayList<>();
        lists.add("技术");
        lists.add("产品");
        EmploymentCondition e=new EmploymentCondition();
        e.setCity(null);
       // e.setKeyword("腾讯");
        e.setPositionList(lists);
        List<Employment> list=employmentDao.queryEmploymentList(e,0,10);

    }
    @Test
    public void testDeleteById(){
       int e =employmentDao.deleteEmploymentByEmploymentId("2","1");
        System.out.println(e);
    }
    @Test
    public void testInsert(){
        Employment employment=new Employment();
        employment.setEmploymentId(UUIDUtils.UUID());

        employment.setUserId("1");
        employment.setCompany("武汉工业");
        employment.setCity("武汉");
        employment.setPosition("产品");
        employment.setPositionName("铁锅产品");
        employment.setIsQuick(1);
        employment.setContact("115898");
        employment.setResumeFormat("简历格式测试");
        employment.setWorkAddr("公司地址测试");
        employment.setPositionDesc("才高八斗");
        employment.setCreateTime(new Date());
        employment.setCompanyLogo("图标路径测试");
        employment.setState(1);
        employmentDao.insertEmployment(employment);
    }


}
