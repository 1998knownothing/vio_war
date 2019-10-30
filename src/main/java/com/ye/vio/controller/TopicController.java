package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.Rent;
import com.ye.vio.entity.Topic;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.service.TopicService;
import com.ye.vio.vo.TopicVo;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: vio
 * @description: 职言模块控制器
 * @author: Mr.liu
 * @create: 2019-08-10 14:27
 **/

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Resource
    private TopicService topicService;

    @RequestMapping(value = "/get/topic/{topicid}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getTopicByTopicId (@PathVariable("topicid")String topicId){


            TopicVo topicVo=topicService.getTopicByTopicId(topicId);

            return ResultDTO.okOf(topicVo);


    }


    @RequestMapping(value = "/get/user/topiclist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentByUserId(HttpServletRequest request,@RequestParam(defaultValue = "1")int page){

        String userId=(String)request.getSession().getAttribute("userId");

        List<Topic> topicList=topicService.getTopicListByUserId(userId,page,10);

            return ResultDTO.okOf(topicList);

    }


    @RequestMapping(value = "/get/topiclist/{type}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getTopicList(String keyword,@PathVariable("type") int type,@RequestParam(defaultValue = "1")int page){

           List<Topic>  topicList=topicService.getTopicList(keyword,type,page,10);

            return ResultDTO.okOf(topicList);


    }


    @RequestMapping(value = "/add/topic",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addTopic(Topic topic, @RequestParam(value = "file",required = false)CommonsMultipartFile file, HttpServletRequest request){

       // String userId=(String)request.getSession().getAttribute("userId");
        String userId="1";
        UserVo userVo=new UserVo();
        userVo.setUserId(userId);

        topic.setUserVo(userVo);

        int effected=topicService.addTopic(topic,file);

            return ResultDTO.okOf(effected);


    }

    @RequestMapping(value = "/remove/topic/{topicid}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeRent(@PathVariable("topicid")String topicId,HttpServletRequest request){

        String userId=(String)request.getSession().getAttribute("userId");

        int effected=topicService.removeTopic(topicId,userId);

            return ResultDTO.okOf(effected);

    }
}
