package com.ye.vio.controller;

import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.dto.RentCondition;
import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.Rent;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.service.RentService;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/get/rent/{rentid}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentByRentId(@PathVariable("rentid")String rentId){

            Rent rent=rentService.getRentByRentId(rentId);

            return ResultDTO.okOf(rent);



    }

    @RequestMapping(value = "/get/user/rentlist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentByUserId(HttpServletRequest request,int page){

            String userId=(String)request.getSession().getAttribute("userId");

            List<Rent> rentList=rentService.getRentListByUserId(userId,page,10);

            return ResultDTO.okOf(rentList);



    }

    @RequestMapping(value = "/get/rentlist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentList(RentCondition rentCondition,int page){

            List<Rent> rentList=rentService.getRentList(rentCondition,page,10);

            return ResultDTO.okOf(rentList);


    }

    @RequestMapping(value = "/add/rent",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addRent(Rent rent,HttpServletRequest request){

        String userId=(String)request.getSession().getAttribute("userId");

        UserVo userVo=new UserVo();
        userVo.setUserId(userId);
        rent.setUser(userVo);

        int effected=rentService.addRent(rent);

            return ResultDTO.okOf(effected);


    }

    @RequestMapping(value = "/remove/rent/{rentid}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeRent(@PathVariable("rentid")String rentId,HttpServletRequest request){

        String userId=(String)request.getSession().getAttribute("userId");

        int effected=rentService.removeRentByRentId(rentId,userId);

            return ResultDTO.okOf(effected);


    }


}
