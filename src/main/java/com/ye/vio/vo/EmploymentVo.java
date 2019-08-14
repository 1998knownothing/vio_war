package com.ye.vio.vo;

import com.ye.vio.entity.Employment;

import java.util.Date;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-06 15:24
 **/
public class EmploymentVo {

    private String employmentId;

    private String positionName;

    private String company;

    private String city;

    private String companyLogo;

    private Date createTime;

    public EmploymentVo(){}

    public EmploymentVo(Employment employment){
        this.employmentId=employment.getEmploymentId();
        this.positionName=employment.getPositionName();
        this.companyLogo=employment.getCompanyLogo();
        this.company=employment.getCompany();
        this.city=employment.getCity();
        this.createTime=employment.getCreateTime();

    }

    public String getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
