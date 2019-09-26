package com.ye.vio.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ApiInterceptor implements HandlerInterceptor{


	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("hello i am prehandle"+request.getContextPath() );
		String userId=(String)request.getSession().getAttribute("userId");
		if(userId!=null)
			return true;
/*		boolean flag=(boolean) request.getSession().getAttribute("userLoginFlag");
		String userno=(String)request.getSession().getAttribute("userNo");
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0)
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("token")) {
					String token = cookie.getValue();
					//先查询session里有无token
					//无查询数据库根据token查询是否有该用户
					break;
				}
			}*/
		response.sendRedirect(request.getContextPath() +"/login.html");
		return false;
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println("hello i am posthandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("hello i am afterhandle");
		
	}

}
