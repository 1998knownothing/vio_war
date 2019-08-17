package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.CollectionEmp;
import com.ye.vio.service.CollectionEmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: vio
 * @description: 收藏控制
 * @author: Mr.liu
 * @create: 2019-08-16 22:33
 **/
@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Resource
    private CollectionEmpService collectionEmpService;


    @RequestMapping(value = "/addcollectionemp",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addCollectionEmp(CollectionEmp collectionEmp){
        try{


        }catch (Exception e){
            
        }

        return null;
    }



}
