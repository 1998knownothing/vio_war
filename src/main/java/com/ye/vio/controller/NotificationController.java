package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.NotificationLike;
import com.ye.vio.entity.NotificationReply;
import com.ye.vio.service.NotificationLikeService;
import com.ye.vio.service.NotificationReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: vio
 * @description:提醒消息控制
 * @author: Mr.liu
 * @create: 2019-08-19 15:59
 **/

@Controller
@RequestMapping("/notification")
public class NotificationController {

    @Resource
    private NotificationReplyService notificationReplyService;

    @Resource
    private NotificationLikeService notificationLikeService;

    @RequestMapping(value = "/reply",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getNotificationReply(HttpServletRequest request, @RequestParam(defaultValue = "1")int page){

        String userId=(String) request.getSession().getAttribute("userId");

        List<NotificationReply> notificationReplyList=notificationReplyService.getNotificationReplyListByToUserId(userId,page,10);

        return ResultDTO.okOf(notificationReplyList);
    }

    @RequestMapping(value = "/like",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getNotificationLike(HttpServletRequest request, @RequestParam(defaultValue = "1")int page){

        String userId=(String) request.getSession().getAttribute("userId");

        List<NotificationLike> notificationLikeList=notificationLikeService.getNotificationLikeListByToUserId(userId,page,10);

        return ResultDTO.okOf(notificationLikeList);
    }

}
