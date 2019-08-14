package com.ye.vio.controller;

import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.House;
import com.ye.vio.entity.Rent;
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
    public Map<String,Object> addHouse(House house,@RequestParam(value = "file") CommonsMultipartFile[] files){
        Map<String,Object> map=new HashMap<>();
        List<CommonsMultipartFile> list=new ArrayList<>();
        UserVo user=new UserVo();
        user.setUserId("1");
        house.setUser(user);
        if(files!=null&&files.length>0){

            for (CommonsMultipartFile c:files){
                list.add(c);
            }
        }
        try {
            int effected=houseService.addHouse(house,list);

            if(effected<=0){
                map.put("success",true);
                map.put("status",404);
                map.put("errMsg","未能添加求租信息");
            }

            map.put("success",true);
            map.put("status",200);
            map.put("msg","成功添加求租信息");

        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
        }
        return  map;
    }

    @RequestMapping(value = "/removehouse/{houseid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> removeHouse(@PathVariable("houseid")String houseId){
        Map<String,Object> map=new HashMap<>();

        String userId="1";

        try {
            int effected=houseService.removeHouseByHouseId(houseId,userId);

            if(effected<=0){
                map.put("success",true);
                map.put("status",404);
                map.put("errMsg","未能删除指定求租信息");
                return map;
            }

            map.put("success",true);
            map.put("status",200);
            map.put("msg","成功删除指定求租信息");

        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
        }
        return  map;
    }



    @RequestMapping(value = "/gethousebyhouseid/{houseid}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getHouseByHouseId(@PathVariable("houseid")String houseId){
        Map<String,Object> map=new HashMap<>();



        try {
            House house=houseService.getHouseByHouseId(houseId);

            map.put("success",true);
            map.put("status",200);
            map.put("house",house);


        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","获取失败");
            map.put("exception",e.getMessage());
        }
        return  map;
    }

    @RequestMapping(value = "/gethouselistbyuserid/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getHouseListByUserId(@PathVariable("userid")String userId,@PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();

        try {
            List<House> houseList=houseService.getHouseListByUserId(userId,pageIndex,10);

            map.put("success",true);
            map.put("status",200);
            map.put("houseList",houseList);


        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
        }
        return  map;
    }
    @RequestMapping(value = "/gethouselist/{pageindex}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getHouseList(RentCondition rentCondition, @PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();

        try {
            List<House> houseList=houseService.getHouseList(rentCondition,pageIndex,10);

            map.put("success",true);
            map.put("status",200);
            map.put("houseList",houseList);


        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
            map.put("status",500);
        }
        return  map;
    }
}
