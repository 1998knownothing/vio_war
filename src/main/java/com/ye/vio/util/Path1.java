package com.ye.vio.util;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-11-22 12:09
 **/
import jdk.internal.dynalink.beans.StaticClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @program:audit_manager
 * @description: 路径工具
 * @author: Mr.liu
 * @create: 2019-07-22 14:05
 **/
public class Path1 {

    private static Logger logger= LoggerFactory.getLogger(Path1.class);

    public static String getBasePath(HttpServletRequest request){
        //获取系统名称
        String os=System.getProperty("os.name");
        String basePath="";
        String path=request.getSession().getServletContext().getRealPath("/");
        if(os.toLowerCase().startsWith("win")){
            basePath=path;
            logger.info("win:"+basePath);
        }else {
            basePath=path;
            logger.info("linux"+basePath);
        }
        logger.info(basePath);
        return basePath;
    }
    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    /**
     * @Description: 获取模板存储路径
     * @Param:
     * @return:
     * @Author: Mr.liu
     * @Date: 2019/7/22
     */
    public static String getTemplatePath(){
        String templatePath="/upload/template/item/"+UUID()+"/";
        return templatePath;
    }
    public static String getProjectAuditRecordUploadFilesPath(){
        String templatePath="/upload/project_record/item/"+UUID()+"/";
        return templatePath;
    }

 /*   public static void main(String []args){
        File file=new File("C:\\Users\\acer\\AppData\\Local\\Temp\\tomcat-docbase.3950189253493763406.8080\\/upload/template/item/a74ce31e44584f78939a5c51a6875ff6/9ci111.rar");
        System.out.println(file.delete());

    }*/

}

