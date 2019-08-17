package com.ye.vio.enums;

import com.ye.vio.exception.ICustomizeErrorCode;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    //全体适用
    OPERATION_ERROR(1001,"您的添加或删除或更新操作失败！"),


//employment

    EMP_ERROR(1003, "招聘信息操作失败"),
    EMP_SUCCESS(1, "招聘信息操作成功"),
    NULL_EMP(1002,"添加招聘信息为空值"),
    EMP_ADD_ERROR(1004,"添加招聘信息失败"),
    EMP_NOT_FOUND(1003, "你找到招聘信息不在了，要不要换个试试？"),
    EMP_DELETE_ERROR(1005,"添加招聘信息失败"),

//collection
    CTOPIC_ADD_ERROR(3001,"收藏topic失败"),
    CTOPIC_UPDATE_ERROR(3002,"更新topic收藏数失败"),
    COLLECTION_EXIST(3003,"已收藏，请勿重复收藏"),

    //HOUSE

    HOUSE_IMG_UPLOAD_ERROR(4001,"房源信息图片上传失败"),
    HOUSE_DELETE_ERROR(4002,"删除房源记录失败"),
    HOUSE_ADD_ERROR(4003,"添加房源记录失败"),

    //rent
    RENT_ADD_ERROR(5001,"求租信息添加失败"),
    RENT_DELETE_ERROR(5001,"求租信息添加失败"),

    //topic
    TOPIC_DELETE_ERROR(6001,"删除话题失败"),
    TOPIC_ADD_ERROR(6002,"添加话题失败"),


    NULL_TOKEN(2001,"token为空"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "当前操作需要登录，请登陆后重试"),
    SYS_ERROR(2004, "服务冒烟了，要不然你稍后再试试！！！"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在了，要不要换个试试？"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008, "兄弟你这是读别人的信息呢？"),
    NOTIFICATION_NOT_FOUND(2009, "消息莫非是不翼而飞了？"),
    FILE_UPLOAD_FAIL(2010, "图片上传失败"),
    INVALID_INPUT(2011, "非法输入"),
    INVALID_OPERATION(2012, "兄弟，是不是走错房间了？"),
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

}
