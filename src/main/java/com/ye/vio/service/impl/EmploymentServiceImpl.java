package com.ye.vio.service.impl;

import com.ye.vio.dao.EmploymentDao;
import com.ye.vio.dto.EmploymentCondition;
import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.entity.Employment;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.enums.EmploymentStateEnum;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.EmploymentService;
import com.ye.vio.util.ImageUtil;
import com.ye.vio.util.PageUtil;
import com.ye.vio.util.PathUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description: 招聘信息服务
 * @author: Mr.liu
 * @create: 2019-08-04 18:50
 **/
@Service
public class EmploymentServiceImpl  implements EmploymentService {

    @Resource
    private EmploymentDao employmentDao;


    @Override
    public Employment getEmploymentByEmploymentId(String employmentId) {

        Employment employment=employmentDao.queryEmploymentByEmploymentId(employmentId);
        return employment;
    }

    @Override
    @Transactional
    public int addEmployment(Employment employment,CommonsMultipartFile logo) {

        if(employment==null){
            throw  new CustomizeException(CustomizeErrorCode.NULL_EMP);
        }
        int effected=0;
        try{
            employment.setState(1);
            employment.setCreateTime(new Date());
            if(logo!=null){
                addEmploymentImg(employment,logo);
            }

            effected=employmentDao.insertEmployment(employment);

            if(effected<=0){
                throw new RuntimeException("招聘信息添加失败");
            }

        }catch (Exception e){
            throw new RuntimeException("add employment error :"+e.getMessage());
        }

        return effected;
    }

    @Override
    @Transactional
    public int removeEmploymentByEmploymentId(String employmentId, String userId) {
        int effectedNum=0;
        try{

            Employment employment=employmentDao.queryEmploymentByEmploymentId(employmentId);
            if (employment.getCompanyLogo()!=null){
                ImageUtil.deleteFile(employment.getCompanyLogo());
            }
            effectedNum=employmentDao.deleteEmploymentByEmploymentId(employmentId,userId);

            if(effectedNum<=0){
                throw  new RuntimeException("商品类别删除失败");
            }
        }catch(Exception e){
            throw new RuntimeException("delete employment error:"+e.getMessage());
        }
        return effectedNum;
    }

    @Override
    public List<Employment> getEmploymentListByUserId(String userId, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        List<Employment> employmentList=employmentDao.queryEmploymentListByUserId(userId,rowIndex,pageSize);

        return employmentList;
    }

    @Override
    public  List<Employment> getEmploymentList(EmploymentCondition employmentCondition, int pageIndex, int pageSize) {

        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        List<Employment> employmentList=employmentDao.queryEmploymentList(employmentCondition,rowIndex,pageSize);
        return employmentList;
    }

    public void addEmploymentImg(Employment employment, CommonsMultipartFile logo){
        //获取图片目录相对值路径
        String dest= PathUtil.getLogoImagePath(employment.getEmploymentId());
        String logoImgAddr= ImageUtil.generateThombnail(logo,dest);
        employment.setCompanyLogo(logoImgAddr);
    }
}
