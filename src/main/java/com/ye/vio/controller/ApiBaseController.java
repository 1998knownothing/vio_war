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
		res.put("code", e.getCode());
		res.put("message", "系统出现bug，请联系你大烨！！！CustomizeException."+e.getMessage());
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return res;
	}

	@ExceptionHandler(value=NullPointerException.class)
	@ResponseBody
	public Map<String,Object> nullPointerHandler(NullPointerException e,HttpServletResponse response){
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code", "5001");
		res.put("message", "系统出现bug，请联系你大烨！！！Null pointer exception."+e.getMessage());
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return res;
	}

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Map<String,Object> exceptionHandler(Exception e,HttpServletResponse response){
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code", "5002");
		res.put("message", "系统出现bug，请联系你大烨！！！exception."+e.getMessage());
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return res;
	}

	
	
	@ExceptionHandler(value=RuntimeException.class)
	@ResponseBody
	public Map<String,Object> runtimeExceptionHandler(RuntimeException e,HttpServletResponse response){
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("code", "5003");
		res.put("message", "系统出现bug，请联系你大烨！！！RuntimeException"+e.getMessage());
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return res;
	}
}
