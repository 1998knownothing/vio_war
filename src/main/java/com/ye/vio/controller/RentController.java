package com.ye.vio.controller;

import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.dto.RentCondition;
import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.Rent;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.service.RentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: vio
 * @description: 求租模块控制器
 * @author: Mr.liu
 * @create: 2019-08-07 16:18
 **/
@Controller
@RequestMapping("/rent")
public class RentController {

    @Resource
    RentService rentService;

    @RequestMapping(value = "/getrentbyrentid/{rentid}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentByRentId(@PathVariable("rentid")String rentId){
        Map<String,Object> map=new HashMap<>();


            Rent rent=rentService.getRentByRentId(rentId);

            return ResultDTO.okOf(rent);



    }

    @RequestMapping(value = "/getrentlistbyuserid/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentByUserId(@PathVariable("userid")String userId,@PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();


            List<Rent> rentList=rentService.getRentListByUserId(userId,pageIndex,10);

            return ResultDTO.okOf(rentList);



    }

    @RequestMapping(value = "/getrentlist/{pageindex}",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO getRentList(RentCondition rentCondition,@PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();


            List<Rent> rentList=rentService.getRentList(rentCondition,pageIndex,10);

            return ResultDTO.okOf(rentList);


    }

    @RequestMapping(value = "/addrent",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addRent(Rent rent){
        Map<String,Object> map=new HashMap<>();


            int effected=rentService.addRent(rent);

            return ResultDTO.okOf(effected);


    }

    @RequestMapping(value = "/removerent/{rentid}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeRent(@PathVariable("rentid")String rentId){
        Map<String,Object> map=new HashMap<>();

        String userId="1";


            int effected=rentService.removeRentByRentId(rentId,userId);

            return ResultDTO.okOf(effected);


    }


}
