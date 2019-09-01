package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.service.CollectionEmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: vio
 * @description: 收藏控制
 * @author: Mr.liu
 * @create: 2019-08-16 22:33
 **/
@Controller
@RequestMapping("/collection")
public class CollectionEmpController {

    @Resource
    private CollectionEmpService collectionEmpService;


    @RequestMapping(value = "/getcollectionemplistbyuserid/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getCollectionEmpListByUserId(@PathVariable("pageindex")int pageIndex
            , HttpServletRequest request){
        String userId=(String) request.getSession().getAttribute("userId");

        List<CollectionEmp> collectionEmpList =collectionEmpService.getCollectionEmpListByUserId(userId,pageIndex,10);

        return ResultDTO.okOf(collectionEmpList);
    }


    @RequestMapping(value = "/addcollectionemp/{collectionEmpId}",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addCollectionEmp(@PathVariable("collectionEmpId")String collectionEmpId, HttpServletRequest request){

        String userId=(String) request.getSession().getAttribute("userId");

        CollectionEmp collectionEmp=new CollectionEmp();
        collectionEmp.setCollectionEmpId(collectionEmpId);
        collectionEmp.setUserId(userId);
        int effected=collectionEmpService.addCollectionEmp(collectionEmp);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/removecollectionemp/{collectionEmpId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeCollectionEmp(@PathVariable("collectionEmpId") String collectionEmpId, HttpServletRequest request){
        String userId=(String) request.getSession().getAttribute("userId");

        int effected=collectionEmpService.removeCollectionEmp(userId,collectionEmpId);

        return ResultDTO.okOf(effected);
    }



}