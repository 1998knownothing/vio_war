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
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ResultDTO getRentByUserId(HttpServletRequest request,@RequestParam(defaultValue = "1")int page){

            String userId=(String)request.getSession().getAttribute("userId");

            List<Rent> rentList=rentService.getRentListByUserId(userId,page,10);

            return ResultDTO.okOf(rentList);



    }

    @RequestMapping(value = "/get/rentlist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getRentList(RentCondition rentCondition,@RequestParam(defaultValue = "1")int page){


        if(rentCondition.getKeyword()==""||rentCondition.getKeyword()==null){//关键词搜索
           rentCondition.setKeyword(null);
        }
            List<Rent> rentList=rentService.getRentList(rentCondition,page,10);

            return ResultDTO.okOf(rentList);


    }

    @RequestMapping(value = "/add/rent",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addRent(int type,int sex,
                             String city,String area,
                             String address,String rental,
                             String contact,
                             String label,String checkInTime,String note,HttpServletRequest request){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(checkInTime, pos);

        String userId=(String)request.getSession().getAttribute("userId");
        Rent rent=new Rent();
        UserVo userVo=new UserVo();
        userVo.setUserId("1");
        rent.setUser(userVo);
        rent.setType(type);
        rent.setSex(sex);
        rent.setCity(city);
        rent.setArea(area);
        rent.setAddress(address);
        rent.setRental(rental);
        rent.setContact(contact);
        rent.setLabel(label);
        rent.setNote(note);
        rent.setCheckInTime(strtodate);

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
