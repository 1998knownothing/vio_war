package com.ye.vio.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: via
 * @description: 请求工具
 * @author: Mr.liu
 * @create: 2019-07-23 01:55
 **/
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request,String key){
        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e) {
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String name) {

        try {
            return Long.valueOf(request.getParameter(name));
        } catch (Exception e) {
            return -1;
        }
    }

    public static Double getDouble(HttpServletRequest request, String name) {

        try {
            return Double.valueOf(request.getParameter(name));
        } catch (Exception e) {
            return -1d;
        }
    }

    public static Boolean getBoolean(HttpServletRequest request, String name) {

        try {
            return Boolean.valueOf(request.getParameter(name));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String name) {
        try {
            String result = request.getParameter(name);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result))
                result = null;
            return result;
        } catch (Exception e) {
            return null;
        }

    }



}
