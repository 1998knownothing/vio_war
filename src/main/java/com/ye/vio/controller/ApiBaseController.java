package com.ye.vio.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ye.vio.exception.CustomizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Restful类API
 * @author liuye
 * @since 1.0
 */
@ControllerAdvice
public  class ApiBaseController {


	@ExceptionHandler(value= CustomizeException.class)
	@ResponseBody
	public Map<String,Object> customizeExceptionHandler(CustomizeException e,HttpServletResponse response){
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code", "5000");
		res.put("message", "系统出现bug，请联系你大烨！！！CustomizeException.");
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return res;
	}

	@ExceptionHandler(value=NullPointerException.class)
	@ResponseBody
	public Map<String,Object> nullPointerHandler(NullPointerException e,HttpServletResponse response){
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code", "5000");
		res.put("message", "系统出现bug，请联系你大烨！！！Null pointer exception.");
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return res;
	}
	

	
	
	@ExceptionHandler(value=ParseException.class)
	@ResponseBody
	public Map<String,Object> parseExceptionHandler(ParseException e,HttpServletResponse response){
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code", "5000");
		res.put("message", "数据转换出错，1.可能是你的错 2.应该是你的错 3.就是你的错（开发者的错）Parse exception.");
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return res;
	}
}
