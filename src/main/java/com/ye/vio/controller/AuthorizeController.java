package com.ye.vio.controller;

import com.ye.vio.dao.AuthDao;
import com.ye.vio.dao.UserDao;
import com.ye.vio.dto.AccessTokenDTO;
import com.ye.vio.dto.GithubUser;
import com.ye.vio.entity.Auth;
import com.ye.vio.entity.User;
import com.ye.vio.provider.GithubProvider;
import com.ye.vio.service.AuthService;
import com.ye.vio.service.UserService;
import com.ye.vio.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-13 18:56
 **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created by codedrinker on 2019/4/24.
 */
@Controller
@Slf4j
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("#{prop.id}")
    private String clientId;

    @Value("#{prop.name}")
    private String clientSecret;

    @Value("#{prop.back}")
    private String redirectUri;

    @Resource
    private UserService userService;

    @Resource
    private AuthService authService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null && githubUser.getId() != null) {
            String token=UUIDUtils.UUID();
           String authId= githubUser.getId().toString();
           String name= githubUser.getName();
           String emial= githubUser.getEmail();
           String imgAddr=githubUser.getAvatar_url();
            User user = new User();
            //查询数据库是否已有该github用户
            Auth authback=authService.getAuthByAuthId(authId);
            if(authback!=null){
                //非第一次登陆，更新user
                user=authback.getUser();
                user.setNickName(name);
                user.setEmail(emial);
                user.setImgAddr(imgAddr);
                userService.modifyUser(user);
                //更新token
                Auth auth=new Auth();
                auth.setAuthId(authId);
                auth.setToken(token);
                auth.setCreateTime(new Date());
                authService.modifyAuth(auth);

            }else{

                Auth auth=new Auth();
                String userId=UUIDUtils.UUID();
                //创建哟用户信息
                user.setUserId(userId);
                user.setNickName(name);
                user.setEmail(emial);
                user.setImgAddr(imgAddr);
                userService.addUser(user);
                //存储关联githu账号信息
                auth.setId(UUIDUtils.UUID());
                auth.setAuthId(authId);
                auth.setToken(token);
                auth.setUser(user);

               authService.addAuth(auth);

            }
            request.getSession().setAttribute("userId",user.getUserId());
            request.getSession().setAttribute("token:",token);
            log.info("用户id："+user.getUserId()+"  用户token:"+token);
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            response.addCookie(cookie);
            return "redirect:/page/personal.html";
        } else {
            log.error("callback get github error,{}", githubUser);
            // 登录失败，重新登录
            return "redirect:/page/personal.html";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("token");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }



}
