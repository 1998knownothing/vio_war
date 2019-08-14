package com.ye.vio.dto;

import lombok.Data;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-13 18:14
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}