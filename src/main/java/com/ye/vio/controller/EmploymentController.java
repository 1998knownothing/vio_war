package com.ye.vio.controller;

import com.ye.vio.dto.EmploymentCondition;
import com.ye.vio.dto.EmploymentExecution;
import com.ye.vio.dto.ResultDTO;
import com.ye.vio.entity.Employment;
import com.ye.vio.enums.CustomizeErrorCode;
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
    @RequestMapping(value = "/getempbyempid/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getEmpById(@PathVariable("id")String id){
        //Map<String,Object> map=new HashMap<>();
        Employment employment =new Employment();
        try {
            employment = employmentService.getEmploymentByEmploymentId(id);

        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }
        return ResultDTO.okOf(employment);
    }

    //根据empid删除用户对应发布的招聘信息
    @RequestMapping(value = "/removeemp/{userid}/{empid}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDTO removeEmp(@PathVariable("empid")String empId,@PathVariable("userid")String userId){


        int effected=0;
        try {
            effected=employmentService.removeEmploymentByEmploymentId(empId,userId);

        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }
        return  ResultDTO.okOf(effected);
    }
    //用户作为发布者添加招聘信息
    @RequestMapping(value = "/addemp",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO addEmp(Employment employment
            ,@RequestParam(value = "logo",required = false) CommonsMultipartFile logo){
        int effected=0;
        try {
            effected= employmentService.addEmployment(employment,logo);


        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }
        return  ResultDTO.okOf(effected);
    }
    //根据用户id获取其所发布的招聘信息  id logo positionName city time
    @RequestMapping(value = "/getemplistbyuserid/{userid}/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getEmpListByUserId(@PathVariable("userid")String userId
            ,@PathVariable("pageindex")int pageIndex){

        try {
            List<Employment> employmentList = employmentService.getEmploymentListByUserId(userId,pageIndex,10);
            List<EmploymentVo> employmentVoList=new ArrayList<>();

            if(employmentList!=null){
                for(Employment employment:employmentList){
                    EmploymentVo vo=new EmploymentVo(employment);
                    employmentVoList.add(vo);
                }
            }
            return  ResultDTO.okOf(employmentVoList);

        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }

    }
    //获取所有招聘信息分页方式
    @RequestMapping(value = "/getemplist/{pageindex}",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getEmpList(@PathVariable("pageindex")int pageIndex, EmploymentCondition employmentCondition){
        try {
            List<Employment> employmentList = employmentService.getEmploymentList(employmentCondition,pageIndex,10);
            List<EmploymentVo> employmentVoList=new ArrayList<>();

            if(employmentList!=null){
                for(Employment employment:employmentList){
                    EmploymentVo vo=new EmploymentVo(employment);
                    employmentVoList.add(vo);
                }
            }
            return  ResultDTO.okOf(employmentVoList);

        }catch (Exception e){
            return ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
        }
    }

}
