package com.ye.vio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;

/**
 * @program: vio
 * @description: 招聘
 * @author: Mr.liu
 * @create: 2019-08-04 13:27
 **/
@Data
public class Employment {

    private String employmentId;

    private String userId;

    private String company;

    private String city;

    private String position;

    private String positionName;

    private int isQuick;

    private String period;

    private String contact;

    private String resumeFormat;

    private String workAddr;

    private String positionDesc;

    @JsonFormat(pattern="yyyy-MM-dd", locale="zh", timezone="GMT+8")
    private Date createTime;

    private String companyLogo;

    private int state;


}
