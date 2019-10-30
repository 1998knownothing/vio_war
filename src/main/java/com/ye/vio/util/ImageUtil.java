package com.ye.vio.util;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @program: via
 * @description: 图片处理
 * @author: Mr.liu
 * @create: 2019-07-22 11:56
 **/
public class ImageUtil {

    private static Logger logger= LoggerFactory.getLogger(ImageUtil.class);
    private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r=new Random();

    public static String generateThombnail(CommonsMultipartFile thumbnail, String targetAddr){
        String relativeAddr=null;
        try {
            String realFileName=getRandomFileName();//获取随机名
            String extension=getFileExtension(thumbnail);//获取扩展名
            makeDirPath(targetAddr);//创建文件目录
            relativeAddr=targetAddr+realFileName+extension;
            logger.debug("current relativeAddr is:"+relativeAddr);
            logger.debug("file:  "+thumbnail.getName());
            logger.debug("basePath: "+basePath);
            logger.debug("current complete addr is:"+PathUtil.getImgBasePath()+relativeAddr);

            File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
            Thumbnails.of(thumbnail.getInputStream())
                    .size(200,200)
                    .outputQuality(0.8f).toFile(dest);//压缩比例


            logger.debug("success++++:"+dest.getAbsolutePath());
        } catch (IOException e) {
            logger.debug(e.getMessage());
            e.printStackTrace();
        }
        return relativeAddr;

    }

    public static List<String> generateNormalImgs(List<CommonsMultipartFile> imgs, String targetAddr) {
        int count = 0;
        List<String> relativeAddrList = new ArrayList<String>();
        if (imgs != null && imgs.size() > 0) {
            makeDirPath(targetAddr);
            for (CommonsMultipartFile img : imgs) {
                String realFileName = getRandomFileName();
                String extension = getFileExtension(img);
                String relativeAddr = targetAddr + realFileName + count + extension;
                File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
                count++;
                try {
                    Thumbnails.of(img.getInputStream()).size(600, 300).outputQuality(0.5f).toFile(dest);
                } catch (IOException e) {
                    throw new RuntimeException("创建图片失败：" + e.toString());
                }
                relativeAddrList.add(relativeAddr);
            }
        }
        return relativeAddrList;
    }

    public static void deleteFile(String storePath) {
        File file = new File(PathUtil.getImgBasePath() + storePath);
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

     /**
     * @Description: 创建目标路径所涉及目录，即/home/work/xx.jpg
     * @Param:
     * @return:
     * @Author: Mr.liu
     * @Date: 2019/7/22
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
        File dirPath=new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }

    }

    /**
        * @Description: 获取输入文件流扩展名
        * @Param:
        * @return:
        * @Author: Mr.liu
        * @Date: 2019/7/22
        */
    private static String getFileExtension(MultipartFile cFile) {
        String originalFileName=cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
 * @Description: 生成随机文件名， 当前年月日小时分钟秒钟+五位随机数
 * @Param:  
 * @return:  
 * @Author: Mr.liu
 * @Date: 2019/7/22 
 */
    private static String getRandomFileName() {
        //获取随机五位数
        int rannum=r.nextInt(89999)+10000;
        String now=sDateFormat.format(new Date());
        return now+rannum;
    }


    public static void main(String[] args) throws IOException {



        Thumbnails.of(new File("C:/Users/acer/Desktop/桌面背景/1.png"))
                .size(200,200).watermark(Positions.BOTTOM_RIGHT, ImageIO
                .read(new File("E:/ideaProjects/test/via/src/main/resources/me.png")),0.25f)//透明度
                .outputQuality(0.8f).toFile("C:/Users/acer/Desktop/桌面背景/1new.png");//压缩比例
    }

}
