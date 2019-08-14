package com.ye.vio.dao;

import com.ye.vio.dto.EmploymentCondition;
import com.ye.vio.entity.Employment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: vio
 * @description: 招聘信息dao
 * @author: Mr.liu
 * @create: 2019-08-04 13:34
 **/
public interface EmploymentDao {

    /**
    * @Description: 根据id 查询相应招聘记录
    * @Param:
    * @return:
    * @Author: Mr.liu
    * @Date: 2019/8/4
    */
    public Employment queryEmploymentByEmploymentId(String employmentId);

    /**
    * @Description: 添加招聘信息
    * @Param:
    * @return:
    * @Author: Mr.liu
    * @Date: 2019/8/4
    */
    public int insertEmployment(Employment employment);

    /**
    * @Description: 根据id删除招聘信息
    * @Param:
    * @return:
    * @Author: Mr.liu
    * @Date: 2019/8/4
    */

    public int deleteEmploymentByEmploymentId(@Param("employmentId")String employmentId, @Param("userId")String userId);

    /**
    * @Description: 根据用户id查找发布的招聘信息
    * @Param:
    * @return:
    * @Author: Mr.liu
    * @Date: 2019/8/5
    */
    public List<Employment> queryEmploymentListByUserId(
            @Param("userId") String userId,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
    * @Description: 下刷 分页查找
    * @Param:
    * @return:
    * @Author: Mr.liu
    * @Date: 2019/8/4
    */

    /**
    * @Description: 岗位类型筛选查找 （分页）  运营，产品，技术，设计，职能，市场
    * @Param:
    * @return:
    * @Author: Mr.liu
    * @Date: 2019/8/4
    */

    /**
    * @Description:  北上广地点+职位或者公司名称搜索招聘信息
    * @Param:
    * @return:
    * @Author: Mr.liu
    * @Date: 2019/8/4
    */
    List<Employment> queryEmploymentList(
            @Param("employmentCondition") EmploymentCondition employmentCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);


}
