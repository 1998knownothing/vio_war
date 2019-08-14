package com.ye.vio.util;

/**
 * @program: via
 * @description: 页面工具
 * @author: Mr.liu
 * @create: 2019-07-26 19:02
 **/
public class PageUtil {

    public static int pageIndexToRowIndex(int pageIndex,int pageSize){
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
