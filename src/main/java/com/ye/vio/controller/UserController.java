package com.ye.vio.controller;

import com.ye.vio.dao.UserDao;
import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.User;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: vio
 * @description: 用户控制器
 * @author: Mr.liu
 * @create: 2019-08-04 00:51
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/getuserbytoken",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getUser(HttpServletRequest request){

        String token=null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }

            if(token!=null)return ResultDTO.errorOf(CustomizeErrorCode.NULL_TOKEN);
            User user=userService.getUserByAuthToken(token);

            return ResultDTO.okOf(user);



    }

}
