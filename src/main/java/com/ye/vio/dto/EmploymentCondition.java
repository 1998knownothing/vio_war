package com.ye.vio.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: vio
 * @description: 招聘信息筛选条件dto
 * @author: Mr.liu
 * @create: 2019-08-04 17:35
 **/
@Data
public class EmploymentCondition {

    //城市
    String city;
    //职位名称公司
    String keyword;
    //
    //多岗位（职位）筛选
    List<String> positionList;


}
