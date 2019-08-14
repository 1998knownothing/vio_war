package com.ye.vio.controller;

import com.ye.vio.dao.TopicDao;
import com.ye.vio.dto.ResultDTO;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.service.TopicService;
import com.ye.vio.vo.TopicVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: vio
 * @description: 页面转跳控制器
 * @author: Mr.liu
 * @create: 2019-08-04 00:51
 **/

@Controller
@RequestMapping("/page")
public class PageController {

    @Resource
    private TopicService topicService;

    @GetMapping("/haha")
    @ResponseBody
    public Object haha(){

        TopicVo topicVos=topicService.getTopicByTopicId("1");
        return ResultDTO.okOf(topicVos);
    }

}
