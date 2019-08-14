package com.ye.vio.controller;

import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.Rent;
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
    public Map<String,Object> getRentByRentId(@PathVariable("rentid")String rentId){
        Map<String,Object> map=new HashMap<>();

        try {
            Rent rent=rentService.getRentByRentId(rentId);

                map.put("success",true);
                map.put("rent",rent);


        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg","获取失败");
            map.put("exception",e.getMessage());
        }
        return  map;
    }

    @RequestMapping(value = "/getrentlistbyuserid/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getRentByUserId(@PathVariable("userid")String userId,@PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();

        try {
            List<Rent> rentList=rentService.getRentListByUserId(userId,pageIndex,10);

            map.put("success",true);
            map.put("status",200);
            map.put("rentList",rentList);


        }catch (Exception e){
            map.put("success",false);

            map.put("errorMsg","服务器出错");
            map.put("status",500);
            map.put("exception",e.getMessage());
        }
        return  map;
    }

    @RequestMapping(value = "/getrentlist/{pageindex}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getRentList(RentCondition rentCondition,@PathVariable("pageindex") int pageIndex){
        Map<String,Object> map=new HashMap<>();

        try {
            List<Rent> rentList=rentService.getRentList(rentCondition,pageIndex,10);

            map.put("success",true);
            map.put("status",200);
            map.put("rentList",rentList);


        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg","服务器出错");
            map.put("exception",e.getMessage());
            map.put("status",500);
        }
        return  map;
    }

    @RequestMapping(value = "/addrent",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addRent(Rent rent){
        Map<String,Object> map=new HashMap<>();

        try {
            int effected=rentService.addRent(rent);

            if(effected<=0){
                map.put("success",true);
                map.put("status",404);
                map.put("errMsg","未能添加求租信息");
                return map;
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

    @RequestMapping(value = "/removerent/{rentid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> removeRent(@PathVariable("rentid")String rentId){
        Map<String,Object> map=new HashMap<>();

        String userId="1";

        try {
            int effected=rentService.removeRentByRentId(rentId,userId);

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


}
