package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.CollectionRent;
import com.ye.vio.entity.CollectionTopic;
import com.ye.vio.entity.Topic;
import com.ye.vio.service.CollectionTopicService;
import com.ye.vio.vo.RentVo;
import com.ye.vio.vo.TopicVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: vio
 * @description: 话题收藏
 * @author: Mr.liu
 * @create: 2019-08-18 17:11
 **/
@Controller
@RequestMapping("/collection")
public class CollectionTopicController {

    @Resource
    private CollectionTopicService collectionTopicService;

    @RequestMapping(value = "/get/topiclist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getCollectionTopicListByUserId(HttpServletRequest request,@RequestParam(defaultValue = "1") int page){

        String userId=(String) request.getSession().getAttribute("userId");

        List<CollectionTopic> collectionTopicList=collectionTopicService.getCollectionTopicListByUserId(userId,page,10);

        return ResultDTO.okOf(collectionTopicList);
    }

    @RequestMapping(value = "/add/topic/{topicid}",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addCollectionTopic(HttpServletRequest request,@PathVariable("topicid") String topicId){

        String userId=(String) request.getSession().getAttribute("userId");

        CollectionTopic collectionTopic=new CollectionTopic();
        Topic topic=new Topic();
        topic.setTopicId(topicId);

        collectionTopic.setUserId(userId);
        collectionTopic.setTopic(topic);

        int effected=collectionTopicService.addCollectionTopic(collectionTopic);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/remove/topic/{collectionTopicId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeCollectionTopicByUserId(HttpServletRequest request, @PathVariable("collectionTopicId")String collectionTopicId){

        String userId=(String) request.getSession().getAttribute("userId");

        int effected=collectionTopicService.removeCollectionTopic(userId,collectionTopicId);


        return ResultDTO.okOf(effected);
    }



}
