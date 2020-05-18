package com.ye.vio.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-11-24 13:53
 **/
public class TestUtil {

    private static Logger logger= LoggerFactory.getLogger(TestUtil.class);

    public static final List<String> fileExtensions=new ArrayList<String>(){
        {//限制上传类型
            add(".jpeg");
            add(".png");
            add(".jpg");
            add(".doc");
            add(".docx");
            add(".xls");
            add(".xlsx");
            add(".pdf");
            add(".zip");
            add(".rar");
        }

    };
    //上传单个文件
    public static String uploadFile( MultipartFile file, String targetPath){

        if(!file.isEmpty()){
            logger.info("进入文件不为空处理---》》");
            String fileName=file.getOriginalFilename();//获取文件名
            String path= PathUtil.getImgBasePath()+targetPath;//构建存储路径
            //System.out.println(targetPath+fileName);
            File filePath=new File(path);//构建父路径
            if(!filePath.exists()){
                logger.info("进入文件夹不存在处理");
                filePath.mkdirs();
            }
            File tempFile=new File(path+fileName);
            logger.info("path+fileName:"+path+fileName);
            try{
                file.transferTo(tempFile);
                logger.info("targetPath+fileName:"+targetPath+fileName);
                return targetPath+fileName;
            }catch (Exception e){
                e.printStackTrace();
                logger.info(e.getMessage());
            }

        }
        return null;

    }

}
