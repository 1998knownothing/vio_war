package com.ye.vio.dto;

import java.util.List;

/**
 * @program: vio
 * @description: 招聘信息筛选条件dto
 * @author: Mr.liu
 * @create: 2019-08-04 17:35
 **/
public class EmploymentCondition {

    //城市
    String city;
    //职位名称公司
    String keyword;
    //
    //多岗位（职位）筛选
    List<String> positionList;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<String> positionList) {
        this.positionList = positionList;
    }
}
