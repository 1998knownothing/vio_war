package com.ye.vio.controller;

import com.ye.vio.entity.Rent;
import com.ye.vio.entity.Topic;
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
    public Map<String,Object> getTopicByTopicId (@PathVariable("topicid")String topicId){
        Map<String,Object> map=new HashMap<>();
        try {
            TopicVo topicVo=topicService.getTopicByTopicId(topicId);

            map.put("success",true);
            map.put("status",200);
            map.put("topicVo",topicVo);


        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg","服务器出错");
            map.put("status",500);
            map.put("exception",e.getMessage());
        }
        return  map;

    }


    @RequestMapping(value = "/gettopiclistbyuserid/{type}/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getRentByUserId(@PathVariable("userid")String userId,@PathVariable("type")int type,@PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();

        try {
            List<Topic> topicList=topicService.getTopicListByUserId(userId,type,pageIndex,10);

            map.put("success",true);
            map.put("status",200);
            map.put("topicList",topicList);
            return map;

        }catch (Exception e){
            map.put("success",false);

            map.put("errorMsg","服务器出错");
            map.put("status",500);
            map.put("exception",e.getMessage());
        }
        return  map;
    }


    @RequestMapping(value = "/gettopiclist/{type}/{pageindex}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getTopicList(String keyword,@PathVariable("type") int type,@PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();

        try {
           List<Topic>  topicList=topicService.getTopicList(keyword,type,pageIndex,10);

            map.put("success",true);
            map.put("status",200);
            map.put("topicList",topicList);
            return map;

        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
            map.put("status",500);
        }
        return  map;
    }


    @RequestMapping(value = "/addtopic",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addTopic(Topic topic){
        Map<String,Object> map=new HashMap<>();

        try {
            int effected=topicService.addTopic(topic);

            if(effected<=0){
                map.put("success",true);
                map.put("status",404);
                map.put("errMsg","未能添加求租信息");
                return map;
            }

            map.put("success",true);
            map.put("status",200);
            map.put("msg","成功添加求租信息");
            return map;

        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
        }
        return  map;
    }

    @RequestMapping(value = "/removetopic/{userid}/{topicid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> removeRent(@PathVariable("topicid")String topicId,@PathVariable("userid")String userId){
        Map<String,Object> map=new HashMap<>();



        try {
            int effected=topicService.removeTopic(topicId,userId);

            if(effected<=0){
                map.put("success",true);
                map.put("status",404);
                map.put("errMsg","未能删除指定求租信息");
                return map;
            }

            map.put("success",true);
            map.put("status",200);
            map.put("msg","成功删除指定求租信息");
            return map;

        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
        }
        return  map;
    }
}
