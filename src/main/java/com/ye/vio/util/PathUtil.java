package com.ye.vio.util;

/**
 * @program: via
 * @description: 路径工具
 * @author: Mr.liu
 * @create: 2019-07-22 14:05
 **/
public class PathUtil {
    //获取系统文件路径所用分隔符
    private static String seperator=System.getProperty("file.separator");

    public static String getImgBasePath(){
        //获取系统名称
        String os=System.getProperty("os.name");
        String basePath="";

        if(os.toLowerCase().startsWith("win")){
            basePath="D:/projectdev/vio";
        }else {
            basePath="/home/xiangze";
        }
        //basePath=basePath.replace("/",seperator);
        System.out.println("---------os:"+os+"  seperator"+seperator);
        return basePath;
    }

     /**
     * @Description: 获取图片存储路径
     * @Param:
     * @return:
     * @Author: Mr.liu
     * @Date: 2019/7/22
     */
     public static String getLogoImagePath(String employmentId){
         String imagePath="/upload/company_logo/item/"+employmentId+"/";
         //imagePath=imagePath.replace("/",seperator);
         return imagePath;
     }

    public static String getHouseImagePath(String houseId){
        String imagePath="/upload/house/item/"+houseId+"/";
        //imagePath=imagePath.replace("/",seperator);
        return imagePath;
    }

    public static String getResumeImagePath(String topicId){
        String imagePath="/upload/topic/item/"+topicId+"/";
        //imagePath=imagePath.replace("/",seperator);
        return imagePath;
    }

}
