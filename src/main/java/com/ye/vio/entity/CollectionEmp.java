package com.ye.vio.entity;

import com.ye.vio.vo.EmploymentVo;

import java.util.Date;

/**
 * @program: vio
 * @description: 招聘信息收藏记录
 * @author: Mr.liu
 * @create: 2019-08-10 15:55
 **/
public class CollectionEmp {

    String collectionEmpId;

    String userId;

    EmploymentVo employmentVo;

    Date createTime;

    public String getCollectionEmpId() {
        return collectionEmpId;
    }

    public void setCollectionEmpId(String collectionEmpId) {
        this.collectionEmpId = collectionEmpId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public EmploymentVo getEmploymentVo() {
        return employmentVo;
    }

    public void setEmploymentVo(EmploymentVo employmentVo) {
        this.employmentVo = employmentVo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
