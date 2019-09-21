package com.ye.vio.controller;

import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.CollectionHouse;
import com.ye.vio.service.CollectionHouseService;
import com.ye.vio.vo.HouseVo;
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
 * @description:房源信息收藏
 * @author: Mr.liu
 * @create: 2019-08-18 16:48
 **/
@Controller
@RequestMapping("/collection")
public class CollectionHouseController {

    @Resource
    private CollectionHouseService collectionHouseService;

    @RequestMapping(value = "/get/houselist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getCollectionHouseListByUserId(HttpServletRequest request,int page){

        String userId=(String) request.getSession().getAttribute("userId");

        List<CollectionHouse> collectionHouseList=collectionHouseService.getCollectionHouseListByUserId(userId,page,10);

        return ResultDTO.okOf(collectionHouseList);
    }

    @RequestMapping(value = "/add/house/{houseid}",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addCollectionHouse(HttpServletRequest request,@PathVariable("houseid") String houseId){

        String userId=(String) request.getSession().getAttribute("userId");

        CollectionHouse collectionHouse=new CollectionHouse();

        HouseVo houseVo=new HouseVo();
        houseVo.setHouseId(houseId);

        collectionHouse.setUserId(userId);
        collectionHouse.setHouseVo(houseVo);

       int effected=collectionHouseService.addCollectionHouse(collectionHouse);

        return ResultDTO.okOf(effected);
    }

    @RequestMapping(value = "/remove/house/{collectionHouseId}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeCollectionHouseByUserId(HttpServletRequest request, @PathVariable("collectionHouseId")String collectionHouseId){

        String userId=(String) request.getSession().getAttribute("userId");

        int effected=collectionHouseService.removeCollectionHouse(userId,collectionHouseId);


        return ResultDTO.okOf(effected);
    }






}
