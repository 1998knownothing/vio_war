package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.ReplyLike;
import com.ye.vio.entity.TopicLike;
import com.ye.vio.service.ReplyLikeService;
import com.ye.vio.service.TopicLikeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-20 00:31
 **/
@Controller
@RequestMapping("/like")
public class LikeController {

    @Resource
    private TopicLikeService topicLikeService;
    @Resource
    private ReplyLikeService replyLikeService;

    @RequestMapping(value = "/topic",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addTopicLike(HttpServletRequest request, TopicLike topicLike){

       String userId=(String) request.getSession().getAttribute("userId");

        topicLike.setUserId(userId);

       int effected=topicLikeService.addTopicLike(topicLike);

       return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addReplyLike(HttpServletRequest request, ReplyLike replyLike){

        String userId=(String) request.getSession().getAttribute("userId");
        replyLike.setUserId(userId);

        int effected=replyLikeService.addReplyLike(replyLike);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/remove/father/{fatherReplyId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeFatherReplyLike(HttpServletRequest request,@PathVariable("fatherReplyId")String fatherReplyId){

        String userId=(String) request.getSession().getAttribute("userId");
        ReplyLike replyLike=new ReplyLike();
        replyLike.setUserId(userId);
        replyLike.setLikedFatherReplyId(fatherReplyId);
        int effected=replyLikeService.removeReplyLike(replyLike);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/remove/son/{sonReplyId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeSonReplyLike(HttpServletRequest request,@PathVariable("sonReplyId")String sonReplyId){

        String userId=(String) request.getSession().getAttribute("userId");
        ReplyLike replyLike=new ReplyLike();
        replyLike.setUserId(userId);
        replyLike.setLikedSonReplyId(sonReplyId);
        int effected=replyLikeService.removeReplyLike(replyLike);

        return ResultDTO.okOf(effected);
    }


    @RequestMapping(value = "/remove/topic/{topicId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeTopicLike(HttpServletRequest request,@PathVariable("topicId")String topicId){

        String userId=(String) request.getSession().getAttribute("userId");
        TopicLike topicLike=new TopicLike();
        topicLike.setLikedTopicId(topicId);
        topicLike.setUserId(userId);

        int effected=topicLikeService.removeTopicLike(topicLike);

        return ResultDTO.okOf(effected);
    }

}
