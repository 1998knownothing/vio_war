package com.ye.vio.controller;

import com.ye.vio.dto.EmploymentCondition;
import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.entity.Employment;
import com.ye.vio.service.EmploymentService;
import com.ye.vio.vo.EmploymentVo;
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
 * @description: 招聘模块管理
 * @author: Mr.liu
 * @create: 2019-08-05 00:01
 **/

@Controller
@RequestMapping("/employment")
public class EmploymentController {

    @Resource
    EmploymentService employmentService;
    //根据empid获取对应详细招聘信息
    @RequestMapping(value = "/getempbyid/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmpById(@PathVariable("id")String id){
        Map<String,Object> map=new HashMap<>();
        try {
            Employment employment = employmentService.getEmploymentByEmploymentId(id);

            map.put("success",true);
            map.put("emp",employment);

        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg","获取失败");
        }
        return  map;
    }
    //根据empid删除用户对应发布的招聘信息
    @RequestMapping(value = "/removeemp/{userid}/{empid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> removeEmp(@PathVariable("empid")String empId,@PathVariable("userid")String userId){

        Map<String,Object> map=new HashMap<>();
        try {
           int e=employmentService.removeEmploymentByEmploymentId(empId,userId);
            map.put("success",true);
            map.put("status",200);
            map.put("emp",e);

        }catch (Exception e){
            map.put("success",false);
            map.put("errorMsg","获取失败");
        }
        return  map;
    }
    //用户作为发布者添加招聘信息
    @RequestMapping(value = "/addemp",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addEmp(Employment employment
            ,@RequestParam(value = "logo",required = false) CommonsMultipartFile logo){
        Map<String,Object> map=new HashMap<>();
        try {
            int e = employmentService.addEmployment(employment,logo);
            map.put("success",true);
            map.put("status",200);
            map.put("emp",e);

        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","获取失败");
        }
        return  map;
    }
    //根据用户id获取其所发布的招聘信息  id logo positionName city time
    @RequestMapping(value = "/getemplistbyuserid/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmpListByUserId(@PathVariable("userid")String userId
            ,@PathVariable("pageindex")int pageIndex){
        Map<String,Object> map=new HashMap<>();
        try {
            List<Employment> employmentList = employmentService.getEmploymentListByUserId(userId,pageIndex,2);
            List<Employment> list=employmentList;
            List<EmploymentVo> employmentVoList=new ArrayList<>();

            if(list!=null){
                for(Employment employment:list){
                    EmploymentVo vo=new EmploymentVo(employment);
                    employmentVoList.add(vo);
                }
            }else {
                map.put("success",true);
                map.put("status",404);
                map.put("emp",employmentVoList);
                return map;
            }


            map.put("success",true);
            map.put("status",200);
            map.put("emp",employmentVoList);


        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","获取失败");
        }
        return  map;
    }
    //获取所有招聘信息分页方式
    @RequestMapping(value = "/getemplist/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmpList(@PathVariable("pageindex")int pageIndex, EmploymentCondition employmentCondition){
        Map<String,Object> map=new HashMap<>();
        try {

            List<Employment> list=employmentService.getEmploymentList(employmentCondition,pageIndex,10);
            List<EmploymentVo> employmentVoList=new ArrayList<>();

            if(list!=null){
                for(Employment employment:list){
                    EmploymentVo vo=new EmploymentVo(employment);
                    employmentVoList.add(vo);
                }
            }else {
                map.put("success",true);
                map.put("status",404);
                map.put("emp",employmentVoList);
                return map;
            }


            map.put("success",true);
            map.put("status",200);
            map.put("emp",employmentVoList);

        }catch (Exception e){
            map.put("success",false);
            map.put("status",500);
            map.put("errorMsg","获取失败");
        }
        return  map;
    }

}
