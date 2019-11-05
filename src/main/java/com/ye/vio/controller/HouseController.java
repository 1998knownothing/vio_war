package com.ye.vio.controller;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.House;
import com.ye.vio.service.HouseService;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

/*
    @RequestMapping(value = "/add/house",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addHouse(int sex,int houseType,int type,String city,String area,String address
            ,String rental,String contact,String topic,String note,String label
            ,@RequestParam(value = "file") CommonsMultipartFile[] files
            , HttpServletRequest request){

        List<CommonsMultipartFile> list=new ArrayList<>();
        String userId=(String)request.getSession().getAttribute("userId");
        House house=new House();
        UserVo user=new UserVo();
        user.setUserId(userId);
        house.setUser(user);
        house.setCity(city);
        house.setArea(area);
        house.setSex(sex);
        house.setHouseType(houseType);
        house.setType(type);
        house.setAddress(address);
        house.setRental(rental);
        house.setContact(contact);
        house.setTopic(topic);
        house.setNote(note);
        house.setLabel(label);

        if(files!=null&&files.length>0){

            for (CommonsMultipartFile c:files){
                list.add(c);
            }
        }
        int effected=houseService.addHouse(house,list);

        return ResultDTO.okOf(effected);


    }
*/

    @RequestMapping(value = "/add/house",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addHouse(House house
            ,@RequestParam(value = "file") CommonsMultipartFile[] files
            , HttpServletRequest request){

        List<CommonsMultipartFile> list=new ArrayList<>();
        String userId=(String)request.getSession().getAttribute("userId");
//        String area=house.getArea();
//        String[] str=area.split(",");
//        house.setCity(str[0]);
//        house.setArea(str[1]);
        UserVo user=new UserVo();
        user.setUserId(userId);
        house.setUser(user);

        if(files!=null&&files.length>0){

            for (CommonsMultipartFile c:files){
                list.add(c);
            }
        }
            int effected=houseService.addHouse(house,list);
        System.out.println(effected);
            return ResultDTO.okOf(effected);


    }

    @RequestMapping(value = "/remove/house/{houseid}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeHouse(@PathVariable("houseid")String houseId, HttpServletRequest request){

            String userId=(String)request.getSession().getAttribute("userId");
            int effected=houseService.removeHouseByHouseId(houseId,userId);
            return ResultDTO.okOf(effected);


    }



    @RequestMapping(value = "/get/house/{houseid}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getHouseByHouseId(@PathVariable("houseid")String houseId){

            House house=houseService.getHouseByHouseId(houseId);

            return ResultDTO.okOf(house);


    }

    @RequestMapping(value = "/get/user/houselist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getHouseListByUserId( @RequestParam(defaultValue = "1")int page, HttpServletRequest request){

            String userId=(String)request.getSession().getAttribute("userId");

            List<House> houseList=houseService.getHouseListByUserId(userId,page,10);

           return ResultDTO.okOf(houseList);


    }
    @RequestMapping(value = "/get/houselist",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getHouseList(RentCondition rentCondition,@RequestParam(defaultValue = "1")int page){



            List<House> houseList=houseService.getHouseList(rentCondition,page,10);

            return ResultDTO.okOf(houseList);



    }


}
