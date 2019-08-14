package com.ye.vio.dto;

import com.ye.vio.entity.Employment;
import com.ye.vio.enums.EmploymentStateEnum;

import java.util.List;

/**
 * @program: vio
 * @description: 执行结果类
 * @author: Mr.liu
 * @create: 2019-08-04 18:56
 **/
public class EmploymentExecution {

    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //总数量
    private int count;
    private int effectedNum;
    //操作招聘信息
    private Employment employment;
    //获取招聘信息employment集合信息
    private List<Employment> employmentList;

    public EmploymentExecution(){}

    //针对失败情况的构造器
    public EmploymentExecution(EmploymentStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }
    public EmploymentExecution(EmploymentStateEnum stateEnum,int effectedNum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.effectedNum=effectedNum;
    }

    public EmploymentExecution(EmploymentStateEnum stateEnum,Employment employment){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.employment =employment;
    }
    // 成功的构造器
    public EmploymentExecution(EmploymentStateEnum stateEnum, List<Employment> employmentList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.employmentList = employmentList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public List<Employment> getEmploymentList() {
        return employmentList;
    }

    public void setEmploymentList(List<Employment> employmentList) {
        this.employmentList = employmentList;
    }

    public int getEffectedNum() {
        return effectedNum;
    }

    public void setEffectedNum(int effectedNum) {
        this.effectedNum = effectedNum;
    }
}
