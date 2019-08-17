package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.Rent;
import com.ye.vio.entity.Topic;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.service.TopicService;
import com.ye.vio.vo.TopicVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/gettopicbytopicid/{topicid}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getTopicByTopicId (@PathVariable("topicid")String topicId){

        try {
            TopicVo topicVo=topicService.getTopicByTopicId(topicId);

            return ResultDTO.okOf(topicVo);

        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }


    }


    @RequestMapping(value = "/gettopiclistbyuserid/{type}/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentByUserId(@PathVariable("userid")String userId,@PathVariable("type")int type,@PathVariable("pageindex") int pageIndex){


        try {
            List<Topic> topicList=topicService.getTopicListByUserId(userId,type,pageIndex,10);

            return ResultDTO.okOf(topicList);

        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }

    }


    @RequestMapping(value = "/gettopiclist/{type}/{pageindex}",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO getTopicList(String keyword,@PathVariable("type") int type,@PathVariable("pageindex") int pageIndex){


        try {
           List<Topic>  topicList=topicService.getTopicList(keyword,type,pageIndex,10);

            return ResultDTO.okOf(topicList);

        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }

    }


    @RequestMapping(value = "/addtopic",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addTopic(Topic topic){


            int effected=topicService.addTopic(topic);

            return ResultDTO.okOf(effected);


    }

    @RequestMapping(value = "/removetopic/{userid}/{topicid}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeRent(@PathVariable("topicid")String topicId,@PathVariable("userid")String userId){


            int effected=topicService.removeTopic(topicId,userId);

            return ResultDTO.okOf(effected);

    }
}
