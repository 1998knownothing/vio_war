package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;

import com.ye.vio.util.FileUtil;
import com.ye.vio.util.Path1;
import com.ye.vio.util.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: vio
 * @description: 页面转跳控制器
 * @author: Mr.liu
 * @create: 2019-08-04 00:51
 **/

@Controller
@RequestMapping("/page")
public class PageController {

    Logger logger= LoggerFactory.getLogger(PageController.class);
    //120.79.148.96

    @GetMapping("/session/{userid}")
    @ResponseBody
    public Object haha(@PathVariable("userid")String userId, HttpServletRequest request){

        request.getSession().setAttribute("userId",userId);

        return ResultDTO.okOf(userId);
    }
    @GetMapping("/hehe")
    @ResponseBody
    public Object hehe(String haha){



        return ResultDTO.okOf(haha);
    }
    @GetMapping("/login.html")
    public String login(){

        return "login";
    }
    @GetMapping("/in.html")
    public String in(){

        return "in";
    }
    @GetMapping("/job.html")
    public String job(){

        return "job";
    }

    @GetMapping("/jobDetail.html")
    public String jobDetail(){

        return "jobDetail";
    }
    @GetMapping("/rent.html")
    public String rent(){

        return "rent";
    }
    @GetMapping("/rentDetail.html")
    public String rentDetail(){

        return "rentDetail";
    }
    @GetMapping("/rentPublish.html")
    public String rentPublish(){

        return "rentPublish";
    }
    @GetMapping("/topic.html")
    public String topic(){

        return "topic";
    }
    @GetMapping("/topicDetail.html")
    public String topicDetail(){

        return "topicDetail";
    }
    @GetMapping("/topicDetail2.html")
    public String topicDetail2(){

        return "topicDetail2";
    }
    @GetMapping("/personal.html")
    public String personal(){

        return "personal";
    }
    @GetMapping("/topicPublish1.html")
    public String topicPublish1(){

        return "topicPublish1";
    }
    @GetMapping("/topicPublish2.html")
    public String topicPublish2(){

        return "topicPublish2";
    }
    @GetMapping("/house.html")
    public String house(){

        return "house";
    }
    @GetMapping("/housePublish.html")
    public String housePublish(){

        return "housePublish";
    }
    @GetMapping("/houseDetail.html")
    public String houseDetail(){

        return "houseDetail";
    }

    @GetMapping("/myPublish.html")
    public String myPublish(){

        return "myPublish";
    }
    @GetMapping("/mynews.html")
    public String mynews(){

        return "mynews";
    }

    @GetMapping("/myCollection.html")
    public String myCollection(){

        return "myCollection";
    }


    @GetMapping("/user.html")
    public String collection(){

        return "user";
    }

    @CrossOrigin()
    @GetMapping("/test")
    @ResponseBody
    public Object test(HttpServletRequest request){
        logger.info("----------test------");
        logger.error("-------error---------");
        String path=request.getSession().getServletContext().getRealPath("/");
        return ResultDTO.okOf("haha"+path);
    }
    @CrossOrigin()
    @PostMapping("/upload")
    @ResponseBody
    public Object test1(HttpServletRequest request, MultipartFile file){

        String path=request.getSession().getServletContext().getRealPath("/");
        String path1=request.getSession().getServletContext().getRealPath("/");
        String targetPath= Path1.getTemplatePath();//获取模板基础存储路径
        try{
            String pathUrl= FileUtil.uploadFile(request,file,targetPath);//存储模板并返回子存储路径
            if(pathUrl==null){
                return ResultDTO.okOf("失败"+path);
            }
            path=pathUrl;
        }catch (Exception e){
            logger.error(e.getMessage());
            ResultDTO.okOf("error"+path);
        }
        return ResultDTO.okOf("pathUrl:"+path+"===="+path1);
    }
    @CrossOrigin()
    @PostMapping("/upload2")
    @ResponseBody
    public Object test2(HttpServletRequest request, MultipartFile file){

        String path=request.getSession().getServletContext().getRealPath("/");
        String path1=request.getSession().getServletContext().getRealPath("/");
        String targetPath= Path1.getTemplatePath();//获取模板基础存储路径
        try{
            String pathUrl= TestUtil.uploadFile(file,targetPath);//存储模板并返回子存储路径
            if(pathUrl==null){
                return ResultDTO.okOf("失败"+path);
            }
            path=pathUrl;
        }catch (Exception e){
            logger.error(e.getMessage());
            ResultDTO.okOf("error"+path);
        }
        return ResultDTO.okOf("pathUrl:"+path+"===="+path1);
    }

}
