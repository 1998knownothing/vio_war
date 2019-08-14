package com.ye.vio.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: via
 * @description: 验证码工具
 * @author: Mr.liu
 * @create: 2019-07-24 12:59
 **/
public class CodeUtil {

    public static boolean checkVerifyCode(HttpServletRequest request){
        String verifyCodeExpected=(String) request.getSession().getAttribute(
                Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual=HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if (verifyCodeActual == null
                || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }


}
