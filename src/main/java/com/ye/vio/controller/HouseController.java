package com.ye.vio.controller;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.House;
import com.ye.vio.entity.Rent;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.service.HouseService;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: vio
 * @description: 房源信息控制器
 * @author: Mr.liu
 * @create: 2019-08-09 13:09
 **/

@Controller
@RequestMapping("/house")
public class HouseController {

    @Resource
    HouseService houseService;


    @RequestMapping(value = "/addhouse",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addHouse(House house,@RequestParam(value = "file") CommonsMultipartFile[] files){

        List<CommonsMultipartFile> list=new ArrayList<>();
        UserVo user=new UserVo();
        user.setUserId("1");
        house.setUser(user);
        if(files!=null&&files.length>0){

            for (CommonsMultipartFile c:files){
                list.add(c);
            }
        }
            int effected=houseService.addHouse(house,list);

            return ResultDTO.okOf(effected);


    }

    @RequestMapping(value = "/removehouse/{houseid}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeHouse(@PathVariable("houseid")String houseId){

        String userId="1";

            int effected=houseService.removeHouseByHouseId(houseId,userId);
            return ResultDTO.okOf(effected);


    }



    @RequestMapping(value = "/gethousebyhouseid/{houseid}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getHouseByHouseId(@PathVariable("houseid")String houseId){

            House house=houseService.getHouseByHouseId(houseId);

            return ResultDTO.okOf(house);


    }

    @RequestMapping(value = "/gethouselistbyuserid/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getHouseListByUserId(@PathVariable("userid")String userId,@PathVariable("pageindex") int pageIndex){


            List<House> houseList=houseService.getHouseListByUserId(userId,pageIndex,10);

           return ResultDTO.okOf(houseList);


    }
    @RequestMapping(value = "/gethouselist/{pageindex}",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO getHouseList(RentCondition rentCondition, @PathVariable("pageindex") int pageIndex){



            List<House> houseList=houseService.getHouseList(rentCondition,pageIndex,10);

            return ResultDTO.okOf(houseList);



    }
}
