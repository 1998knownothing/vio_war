package com.ye.vio.dto;

import lombok.Data;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-13 18:14
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String email;
    private String node_id;
    private String avatar_url;
}
