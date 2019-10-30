package com.ye.vio.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ye.vio.entity.Employment;
import lombok.Data;

import java.util.Date;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-06 15:24
 **/
@Data
public class EmploymentVo {

    private String employmentId;

    private String positionName;

    private String position;

    private String company;

    private String city;

    private String companyLogo;

    private String period;

    private int isQuick;

    @JsonFormat(pattern="yyyy-MM-dd", locale="zh", timezone="GMT+8")
    private Date createTime;

    public EmploymentVo(){}

    public EmploymentVo(Employment employment){
        this.employmentId=employment.getEmploymentId();
        this.positionName=employment.getPositionName();
        this.companyLogo=employment.getCompanyLogo();
        this.company=employment.getCompany();
        this.city=employment.getCity();
        this.createTime=employment.getCreateTime();
        this.period=employment.getPeriod();
        this.isQuick=employment.getIsQuick();
        this.position=employment.getPosition();
    }


}
