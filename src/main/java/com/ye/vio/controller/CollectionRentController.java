package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;

import com.ye.vio.entity.CollectionRent;
import com.ye.vio.service.CollectionRentService;

import com.ye.vio.vo.RentVo;
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
 * @description: 求租信息收藏管理
 * @author: Mr.liu
 * @create: 2019-08-18 17:03
 **/
@Controller
@RequestMapping("/collection")
public class CollectionRentController {

    @Resource
    private CollectionRentService collectionRentService;

    @RequestMapping(value = "/getcollectionrentlistbyuserid/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getCollectionRentListByUserId(HttpServletRequest request, @PathVariable("pageindex") int pageIndex){

        String userId=(String) request.getSession().getAttribute("userId");

        List<CollectionRent> collectionRentList=collectionRentService.getCollectionRentListByUserId(userId,pageIndex,10);

        return ResultDTO.okOf(collectionRentList);
    }

    @RequestMapping(value = "/addcollectionRent/{rentid}",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addCollectionRent(HttpServletRequest request,@PathVariable("rentid") String rentId){

        String userId=(String) request.getSession().getAttribute("userId");

        CollectionRent collectionRent=new CollectionRent();

       RentVo rentVo=new RentVo();
        rentVo.setRentId(rentId);

        collectionRent.setUserId(userId);
        collectionRent.setRentVo(rentVo);

        int effected=collectionRentService.addCollectionRent(collectionRent);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/removecollectionrent/{collectionRentId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeCollectionRentByUserId(HttpServletRequest request, @PathVariable("collectionRentId")String collectionRentId){

        String userId=(String) request.getSession().getAttribute("userId");

        int effected=collectionRentService.removeCollectionRent(userId,collectionRentId);


        return ResultDTO.okOf(effected);
    }

}
