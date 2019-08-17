package com.ye.vio.exception;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-13 16:12
 **/
public class CustomizeException extends RuntimeException{

    private String message;
    private Integer code;

    public CustomizeException(Integer errorCode,String message) {
        this.code = errorCode;
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
