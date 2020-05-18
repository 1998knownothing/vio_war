package com.ye.vio.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: audit_manager
 * @description: 文件存储工具
 * @author: Mr.liu
 * @create: 2019-10-02 22:14
 **/
public class FileUtil {

    private static Logger logger= LoggerFactory.getLogger(FileUtil.class);

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
    public static String uploadFile(HttpServletRequest request,MultipartFile file, String targetPath){

        if(!file.isEmpty()){
            logger.info("进入文件不为空处理---》》");
            String fileName=file.getOriginalFilename();//获取文件名
            String path= Path1.getBasePath(request)+targetPath;//构建存储路径
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
    //批量上传文件
    public static String uploadFiles(HttpServletRequest request,List<MultipartFile> files, String targetPath){
        if (files != null && files.size() > 0) {

            for (MultipartFile file : files) {
                if(!file.isEmpty()){
                    String fileName=file.getOriginalFilename();//获取文件名
                    String path= Path1.getBasePath(request)+targetPath;//构建存储路径
                    //System.out.println(targetPath+fileName);
                    File filePath=new File(path);//构建父路径
                    if(!filePath.exists()){
                        filePath.mkdirs();
                    }
                    File tempFile=new File(path+fileName);

                    try{
                        file.transferTo(tempFile);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }else {
            throw new RuntimeException();
        }

        return targetPath;

    }
   /* //删除指定目录下所有文件
    public static void deleteFile(String storePath) {
        File file = new File(Path1.getBasePath() + storePath);
        if (file.exists()) {
            if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            file.delete();
        }
    }
    //获取扩展名
    public static String getFileExtension(MultipartFile cFile) {
        String originalFileName=cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }
    //获取指定目录下的文件列表
    public static List<String> getTargetPathFiles(String targetPath, HttpServletRequest request){
        String contextPath = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+
                request.getServerPort()+contextPath;
        List<String> filePathList=new ArrayList<>();
        File file = new File(Path1.getBasePath() + targetPath);
        if (file.exists()) {
            if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    filePathList.add(basePath+targetPath+"/"+files[i].getName());
                }
            }
        }
        return filePathList;
    }*/


}
