package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.FatherReply;
import com.ye.vio.entity.SonReply;
import com.ye.vio.service.FatherReplyService;
import com.ye.vio.service.SonReplyService;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: vio
 * @description: 评论管理
 * @author: Mr.liu
 * @create: 2019-08-19 01:18
 **/

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private FatherReplyService fatherReplyService;
    @Resource
    private SonReplyService sonReplyService;

    @RequestMapping(value = "/addfather",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addFatherReply(FatherReply fatherReply, HttpServletRequest  request){


        String userId=(String)request.getSession().getAttribute("userId");

        //userId="8e34ab525497494e8cfddbf4c6f11f46";

        UserVo userVo=new UserVo();
        userVo.setUserId(userId);
        fatherReply.setUserVo(userVo);

        int effected=fatherReplyService.addFatherReply(fatherReply);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/removefather/{topicId}/{fatherReplyId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeFatherReply( @PathVariable("topicId")String topicId
                                     ,@PathVariable("fatherReplyId") String fatherReplyId
                                         , HttpServletRequest  request){


        String userId=(String)request.getSession().getAttribute("userId");

        int effected=fatherReplyService.removeFatherReplyByUserIdAndFatherReplyId(userId,fatherReplyId,topicId);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/addson",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addSonReply(SonReply sonReply, HttpServletRequest  request){


        String userId=(String)request.getSession().getAttribute("userId");


        UserVo userVo=new UserVo();
        userVo.setUserId(userId);
        sonReply.setUserVo(userVo);

        int effected=sonReplyService.addSonReply(sonReply);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/removeson/{topicId}/{sonReplyId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeSonReply(@PathVariable("topicId")String topicId, @PathVariable("sonReplyId") String sonReplyId,HttpServletRequest  request){


        String userId=(String)request.getSession().getAttribute("userId");

        int effected=sonReplyService.removeSonReplyByUserIdAndSonReplyId(userId,sonReplyId,topicId);

        return ResultDTO.okOf(effected);
    }


}
