package com.ye.vio.service;

import com.ye.vio.dto.EmploymentCondition;
import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.entity.Employment;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface EmploymentService {

    public Employment getEmploymentByEmploymentId(String employmentId);

    public int addEmployment(Employment employment, CommonsMultipartFile logo);

    public int removeEmploymentByEmploymentId(String employmentId, String userId);

    List<Employment> getEmploymentListByUserId(String userId,int pageIndex,int pageSize);

    List<Employment> getEmploymentList(
            EmploymentCondition employmentCondition,
             int pageIndex,  int pageSize);

}
